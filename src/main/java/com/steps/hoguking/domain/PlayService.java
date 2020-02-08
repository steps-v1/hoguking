package com.steps.hoguking.domain;

import com.google.cloud.firestore.Query;
import com.steps.hoguking.support.util.DateUtils;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PlayService extends FireStoreService {
	@Override
	public String getCollectionName() {
		return "PLAY";
	}


	public void addPlayResult(Play play) {
		play.setPlayId(UUID.randomUUID().toString());
		save(play);
	}

	@SneakyThrows
	public List<Play> getPlayList(String memberId, int limit, int offset) {
		return getCollection().whereArrayContains("players", memberId)
				.orderBy("playDateTime", Query.Direction.DESCENDING)
				.limit(limit)
				.offset(offset)
				.get()
				.get()
				.getDocuments()
				.stream()
				.map(documentSnapshot -> documentSnapshot.toObject(Play.class))
				.collect(Collectors.toList());
	}

	@SneakyThrows
	public List<Hogu> getHoguList(String organizationId, int year, int month) {
		return getCollection()
				.whereEqualTo("organizationId", organizationId)
				.whereGreaterThanOrEqualTo("playDateTime", DateUtils.getFirstDayOfMonth(year, month))
				.whereLessThanOrEqualTo("playDateTime", DateUtils.getLastDayOfMonth(year, month))
				.get()
				.get()
				.getDocuments()
				.stream()
				.map(documentSnapshot -> documentSnapshot.toObject(Play.class))
				.collect(Collectors.groupingBy(Play::getHoguKingId, Collectors.counting()))
				.entrySet()
				.stream()
				.map(entry -> new Hogu(entry.getKey(), entry.getValue()))
				.collect(Collectors.toList());
	}
}
