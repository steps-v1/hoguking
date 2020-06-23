package com.steps.hoguking.infrastructure.repository;

import com.steps.hoguking.domain.Member;
import com.steps.hoguking.support.util.HogukingRepositoryTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class MemberRepositoryTest extends HogukingRepositoryTest {
	@Autowired
	private MemberRepository memberRepository;

	@Test
	public void findByIdTest() {
		memberRepository.save(new Member().setId("a").setName("xxx").setAlias("aaa").setPassword("asdfsdf"));

		Optional<Member> member = memberRepository.findById("a");
		assertThat(member.get().getId()).isEqualTo("a");
	}
}