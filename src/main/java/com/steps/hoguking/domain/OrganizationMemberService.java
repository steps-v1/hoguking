package com.steps.hoguking.domain;

import org.springframework.stereotype.Service;

@Service
public class OrganizationMemberService extends FireStoreService {

	public void addMember(String organizationId, String memberId) {
		save(new OrganizationMember(organizationId, memberId));
	}

	@Override
	public String getCollectionName() {
		return "ORGANIZATION_MEMBER";
	}
}
