package com.steps.hoguking.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
public class FireStoreConfig {
	private String projectId = "hoguking-d5555";
	private String serviceAccountFileName = "hoguking-d5555-a9d4b58fea7a.json";

	@Bean
	public Firestore fireStore() throws IOException {

		InputStream serviceAccountInputStream = getClass().getClassLoader().getResourceAsStream(serviceAccountFileName);
		GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccountInputStream);
		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(credentials)
				.setProjectId(projectId)
				.build();
		FirebaseApp.initializeApp(options);

		return FirestoreClient.getFirestore();
	}
}
