package com.steps.hoguking.interfaces.web;

import com.steps.hoguking.domain.*;
import com.steps.hoguking.interfaces.web.protocol.*;
import com.steps.hoguking.support.util.ModelConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.steps.hoguking.support.util.ModelConverter.convert;

@RestController
public class OrganizationController {
	@Autowired
	private OrganizationService organizationService;
	@Autowired
	private OrganizationMemberService organizationMemberService;
	@Autowired
	private PlayService playService;

	@PostMapping("/hoguking/v1.0/organizations")
	public OrganizationResponse createOrganization(@Valid @RequestBody OrganizationRequest request,
	                                               Token token) {
		Organization organization = organizationService.create(
				convert(request, Organization.class),
				token.getMemberId());

		return convert(organization, OrganizationResponse.class);
	}

	@PostMapping("/hoguking/v1.0/organizations/{id}/members")
	public void addOrganizationMember(@Valid @RequestBody OrganizationMemberRequest request,
	                                  @PathVariable("id") String organizationId,
	                                  Token token) {

		organizationMemberService.addMember(
				organizationId,
				request.getMemberId());

	}

	@GetMapping("/hoguking/v1.0/organizations/{id}/hogus")
	public HoguResponse findHogus(@PathVariable("id") String organizationId, int year, int month) {
		List<Hogu> hoguList = playService.getHoguList(organizationId, year, month);

		return new HoguResponse().setHogus(ModelConverter.convertHoguList(hoguList, HoguProtocol.class));
	}
}
