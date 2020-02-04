package com.steps.hoguking.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

@Data
@Accessors(chain = true)
public class Member {
	@NotBlank
	private String id;
	@NotBlank
	private String name;
	@NotBlank
	private String alias;
	@NotBlank
	private String password;
}
