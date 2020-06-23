package com.steps.hoguking.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "play")
public class Play {
	@Id
	private String playId;
	private String organizationId;
	private String hoguKingId;
	private String playName;
	private Date playDateTime;
}
