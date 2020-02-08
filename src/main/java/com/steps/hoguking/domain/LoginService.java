package com.steps.hoguking.domain;

import com.steps.hoguking.support.util.DateUtils;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LoginService extends FireStoreService {

	@Autowired
	private MemberService memberService;


	public Token login(String id, String password) {
		Member member = memberService.getMember(id);
		if (member == null) {
			throw new RuntimeException("가입된 회원이 아님.");
		}

		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		if (bCryptPasswordEncoder.matches(password, member.getPassword()) != false) {
			throw new RuntimeException("비밀번호 틀림");
		}

		Token token = new Token();
		token.setMemberId(id);
		token.setToken("HK-" + UUID.randomUUID().toString());
		token.setExpire(DateUtils.plusMonth(3));

		save(token);

		return token;
	}


	@SneakyThrows
	public Token getToken(String token) {
		return findOne("token", token, Token.class);
	}


	@Override
	public String getCollectionName() {
		return "TOKEN";
	}
}
