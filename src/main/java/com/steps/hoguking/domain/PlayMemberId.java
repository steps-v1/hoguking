package com.steps.hoguking.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class PlayMemberId implements Serializable {
	private String playId;
	private String memberId;
}
