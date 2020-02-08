package com.steps.hoguking.domain;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;


abstract public class FireStoreService {
	@Autowired
	private Firestore fireStore;

	public abstract String getCollectionName();

	protected CollectionReference getCollection() {
		return fireStore.collection(getCollectionName());
	}

	@SneakyThrows
	protected void save(Object obj) {
		ApiFuture<DocumentReference> future = getCollection().add(obj);
		future.get();
	}

	@SneakyThrows
	protected <T> T findOne(String key, String value, Class<T> clazz) {
		Query query = getCollection().whereEqualTo(key, value);
		ApiFuture<QuerySnapshot> future = query.get();
		QuerySnapshot querySnapshot = future.get();

		if (querySnapshot.isEmpty()) {
			return null;
		} else {
			return querySnapshot.getDocuments().get(0).toObject(clazz);
		}
	}
}
