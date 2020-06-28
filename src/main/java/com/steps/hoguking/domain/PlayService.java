package com.steps.hoguking.domain;

import com.steps.hoguking.infrastructure.repository.PlayRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PlayService {
	@Autowired
	private PlayRepository playRepository;

	public void addPlayResult(Play play) {
		play.setPlayId(UUID.randomUUID().toString());
		playRepository.save(play);
	}

	@SneakyThrows
	public List<Play> getPlayList(String memberId, int limit, int offset) {
		return playRepository.findAll();
	}

}
