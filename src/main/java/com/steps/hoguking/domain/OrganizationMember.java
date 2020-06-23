package com.steps.hoguking.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "org_member")
public class OrganizationMember {
	@EmbeddedId
	private OrganizationMemberId organizationMemberId;

	public OrganizationMember(String organizationId, String memberId) {
		organizationMemberId = new OrganizationMemberId(organizationId, memberId);
	}
}
