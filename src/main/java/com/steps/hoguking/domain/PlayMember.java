package com.steps.hoguking.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "play_member")
public class PlayMember {
	@EmbeddedId
	private PlayMemberId playMemberId;
}
