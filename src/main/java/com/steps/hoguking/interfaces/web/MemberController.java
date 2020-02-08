package com.steps.hoguking.interfaces.web;

import com.steps.hoguking.domain.Member;
import com.steps.hoguking.domain.MemberService;
import com.steps.hoguking.interfaces.web.protocol.MemberProtocol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.steps.hoguking.support.util.ModelConverter.convert;

@RestController
public class MemberController {
	@Autowired
	private MemberService memberService;

	@PostMapping("/hoguking/v1.0/members")
	public void getMember(@RequestBody MemberProtocol memberProtocol) {
		Member member = convert(memberProtocol, Member.class);
		memberService.signUp(member);
	}
}
