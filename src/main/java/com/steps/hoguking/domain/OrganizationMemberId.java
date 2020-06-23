package com.steps.hoguking.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class OrganizationMemberId implements Serializable {
	private String organizationId;
	private String memberId;
}
