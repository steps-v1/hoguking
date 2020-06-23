package com.steps.hoguking.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "org")
public class Organization {
	@Id
	public String id;
	public String name;
}
