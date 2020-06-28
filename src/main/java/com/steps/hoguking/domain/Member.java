package com.steps.hoguking.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Accessors(chain = true)
@Entity(name = "member")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	@Id
	private String id;
	private Date regDateTime;
	private Date modDateTime;
}
