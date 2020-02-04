package com.steps.hoguking.interfaces.web;

import com.steps.hoguking.domain.Member;
import com.steps.hoguking.domain.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {
	@Autowired
	private MemberService memberService;

	@PostMapping("/hoguking/v1.0/members")
	public void getMember(@RequestBody Member member) {
		memberService.signUp(member);
	}
}
