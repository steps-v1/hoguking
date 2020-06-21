package com.steps.hoguking.interfaces.web;

import com.steps.hoguking.domain.PlayService;
import com.steps.hoguking.interfaces.web.protocol.PlayRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class PlayControllerTest {

	@Mock
	private PlayService playService;

	@InjectMocks
	private PlayController playController;

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void play() {
		PlayRequest request = Mockito.mock(PlayRequest.class);
		Mockito.when(request.getHoguKingId()).thenReturn("id");


		playController.play(request);

		Mockito.verify(playService).addPlayResult(Mockito.any());
	}

	@Test
	void play1() {
	}
}