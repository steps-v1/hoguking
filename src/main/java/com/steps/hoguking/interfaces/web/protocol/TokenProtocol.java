package com.steps.hoguking.interfaces.web.protocol;

import lombok.Data;

import java.util.Date;

@Data
public class TokenProtocol {
	private String token;
	private Date expire;
}
