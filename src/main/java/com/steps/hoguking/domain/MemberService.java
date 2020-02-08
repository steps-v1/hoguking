package com.steps.hoguking.domain;

import com.google.cloud.firestore.Firestore;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService extends FireStoreService {

	@Autowired
	private Firestore fireStore;

	@SneakyThrows
	public Member getMember(String id) {
		return findOne("id", id, Member.class);
	}


	@SneakyThrows
	public void signUp(Member member) {
		if (getMember(member.getId()) != null) {
			throw new RuntimeException("duplicated id");
		}

		save(member);
	}

	@Override
	public String getCollectionName() {
		return "MEMBER";
	}
}
