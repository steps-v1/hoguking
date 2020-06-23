package com.steps.hoguking.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Accessors(chain = true)
@Entity(name = "member")
public class Member {
	@Id
	private String id;
	private String name;
	private String alias;
	private String password;
}
