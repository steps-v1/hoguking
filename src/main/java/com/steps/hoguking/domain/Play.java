package com.steps.hoguking.domain;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Play {
	private String playId;
	private String organizationId;
	private String hoguKingId;
	private String playName;
	private List<String> players;
	private Date playDateTime;
}
