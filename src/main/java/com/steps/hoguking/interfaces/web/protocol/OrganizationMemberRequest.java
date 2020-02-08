package com.steps.hoguking.interfaces.web.protocol;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class OrganizationMemberRequest {
	@NotBlank
	private String memberId;
}
