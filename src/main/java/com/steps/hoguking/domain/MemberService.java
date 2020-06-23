package com.steps.hoguking.domain;

import com.steps.hoguking.infrastructure.repository.MemberRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class MemberService {
	@Autowired
	private MemberRepository memberRepository;


	@SneakyThrows
	public Member getMember(String id) {
		return memberRepository.getOne(id);
	}


	@SneakyThrows
	@Transactional
	public void signUp(Member member) {
		if (getMember(member.getId()) != null) {
			throw new RuntimeException("duplicated id");
		}

		memberRepository.save(member);
	}
}
