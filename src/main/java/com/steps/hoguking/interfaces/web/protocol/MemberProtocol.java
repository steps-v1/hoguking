package com.steps.hoguking.interfaces.web.protocol;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class MemberProtocol {
	@NotBlank
	private String id;
	@NotBlank
	private String name;
	@NotBlank
	private String alias;
	@NotBlank
	private String password;
}
