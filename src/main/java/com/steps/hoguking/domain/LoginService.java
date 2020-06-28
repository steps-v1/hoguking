package com.steps.hoguking.domain;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;

@Slf4j
@Service
public class LoginService {

	@Autowired
	private MemberService memberService;

	@SneakyThrows
	@PostConstruct
	public void post() {
		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.getApplicationDefault())
				.setDatabaseUrl("https://hoguking-d5555.firebaseio.com")
				.build();

		FirebaseApp.initializeApp(options);
	}

	@SneakyThrows
	public Member getMember(String idTokenString) {
		log.info("check Token {}", idTokenString);

		FirebaseToken decodedToken = FirebaseAuth.getInstance()
				.verifyIdToken(idTokenString);

		if (decodedToken != null) {
			String userId = decodedToken.getUid();
			log.info("login userId {}", userId);

			// Get profile information from payload
			String email = decodedToken.getEmail();
			log.info("login email {}", email);

			Member member = memberService.getMember(email);
			if (member == null) {
				memberService.signUp(Member.builder()
						.id(email)
						.regDateTime(new Date())
						.build());
			}
			return memberService.getMember(email);
		} else {
			throw new RuntimeException("oauth fail");
		}
	}
}
