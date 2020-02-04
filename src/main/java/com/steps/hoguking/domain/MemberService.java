package com.steps.hoguking.domain;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	private String collectionName = "MEMBER";

	@Autowired
	private Firestore fireStore;

	@SneakyThrows
	public Member getMember(String id) {
		Query query = getMemberCollection().whereEqualTo("id", id);
		ApiFuture<QuerySnapshot> future = query.get();
		QuerySnapshot querySnapshot = future.get();

		if (querySnapshot.isEmpty()) {
			return null;
		} else {
			return querySnapshot.getDocuments().get(0).toObject(Member.class);
		}
	}

	private CollectionReference getMemberCollection() {
		return fireStore.collection(collectionName);
	}

	@SneakyThrows
	public void signUp(Member member) {
		if (getMember(member.getId()) != null) {
			throw new RuntimeException("duplicated id");
		}

		ApiFuture<DocumentReference> result = getMemberCollection().add(member);
		result.get();
	}
}
