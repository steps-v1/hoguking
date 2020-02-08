package com.steps.hoguking.interfaces.web.protocol;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class OrganizationRequest {
	@NotBlank
	private String name;
}
