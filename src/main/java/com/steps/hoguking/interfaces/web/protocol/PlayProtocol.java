package com.steps.hoguking.interfaces.web.protocol;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class PlayProtocol {
	private String playId;
	private String organizationId;
	private List<String> players;
	private String hoguKingId;
	private String playName;
	private Date playDateTime;
}
