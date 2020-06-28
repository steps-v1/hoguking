package com.steps.hoguking.interfaces.web;

import com.steps.hoguking.domain.Member;
import com.steps.hoguking.domain.Play;
import com.steps.hoguking.domain.PlayService;
import com.steps.hoguking.interfaces.web.protocol.PlayListResponse;
import com.steps.hoguking.interfaces.web.protocol.PlayProtocol;
import com.steps.hoguking.interfaces.web.protocol.PlayRequest;
import com.steps.hoguking.support.util.ModelConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

import static com.steps.hoguking.support.util.ModelConverter.convert;

@RestController
public class PlayController {
	@Autowired
	private PlayService playService;

	@PostMapping("/hoguking/v1.0/plays")
	public void play(@Valid @RequestBody PlayRequest request) {
		playService.addPlayResult(convert(request, Play.class));
	}

	@GetMapping("/hoguking/v1.0/plays")
	public PlayListResponse play(Member member, int limit, int offset) {
		List<Play> plays = playService.getPlayList(member.getId(), limit, offset);

		return new PlayListResponse().setPlays(ModelConverter.convert(plays, PlayProtocol.class));
	}
}
