package com.steps.hoguking.domain;

import com.steps.hoguking.infrastructure.repository.OrganizationMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class OrganizationMemberService {
	@Autowired
	private OrganizationMemberRepository organizationMemberRepository;


	@Transactional
	public void addMember(String organizationId, String memberId) {
		organizationMemberRepository.save(new OrganizationMember(organizationId, memberId));
	}
}
