package com.steps.hoguking.interfaces.web.protocol;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class PlayListResponse {
	private List<PlayProtocol> plays;
}
