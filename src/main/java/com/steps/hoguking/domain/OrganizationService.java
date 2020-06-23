package com.steps.hoguking.domain;

import com.steps.hoguking.infrastructure.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrganizationService {
	@Autowired
	private OrganizationMemberService organizationMemberService;
	@Autowired
	private OrganizationRepository organizationRepository;

	public Organization create(Organization organization, String memberId) {
		organization.setId(UUID.randomUUID().toString());

		organizationRepository.save(organization);

		organizationMemberService.addMember(organization.getId(), memberId);

		return organizationRepository.getOne(organization.getId());
	}

}
