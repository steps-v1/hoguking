package com.steps.hoguking.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Token {
	private String memberId;
	private String token;
	private Date expire;
}
