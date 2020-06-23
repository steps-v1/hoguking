package com.steps.hoguking.interfaces.web;

import com.steps.hoguking.domain.*;
import com.steps.hoguking.interfaces.web.protocol.OrganizationMemberRequest;
import com.steps.hoguking.interfaces.web.protocol.OrganizationRequest;
import com.steps.hoguking.interfaces.web.protocol.OrganizationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
}
