package com.steps.hoguking.domain;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Member {
	private String documentId;
	private String id;
	private String name;
}
