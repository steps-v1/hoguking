package com.steps.hoguking.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrganizationService extends FireStoreService {
	@Autowired
	private OrganizationMemberService organizationMemberService;

	public Organization create(Organization organization, String memberId) {
		organization.setId(UUID.randomUUID().toString());
		save(organization);

		organizationMemberService.addMember(organization.getId(), memberId);

		return findOne("id", organization.getId(), Organization.class);
	}


	@Override
	public String getCollectionName() {
		return "ORGANIZATION";
	}
}
