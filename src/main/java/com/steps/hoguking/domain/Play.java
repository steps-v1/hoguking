package com.steps.hoguking.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "play")
public class Play {
	@Id
	private String playId;
	private String playName;
	private Date playDateTime;

	@OneToOne
	private Member hoguking;

	@OneToMany
	private List<Member> players;
}
