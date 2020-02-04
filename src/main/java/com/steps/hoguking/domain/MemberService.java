package com.steps.hoguking.domain;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class MemberService {
	@Autowired
	private Firestore firestore;

	public Member getMember(Member member) throws ExecutionException, InterruptedException {
		CollectionReference docRef = firestore.collection("MEMBER");
		Query query = docRef.whereEqualTo("id", member.getId());
		ApiFuture<QuerySnapshot> future = query.get();
		QuerySnapshot snapShot = future.get();
		List<QueryDocumentSnapshot> documents = snapShot.getDocuments();

		QueryDocumentSnapshot document = documents.get(0);
		return new Member().setName(document.getString("name"))
				.setId(document.getString("id"))
				.setDocumentId(document.getId());
	}
}
