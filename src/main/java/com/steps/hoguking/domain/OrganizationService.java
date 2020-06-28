package com.steps.hoguking.domain;

import com.steps.hoguking.infrastructure.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class OrganizationService {
	@Autowired
	private OrganizationRepository organizationRepository;
	@Autowired
	private MemberService memberService;

	@Transactional
	public Organization create(Organization organization, String memberId) {
		organization.setId(UUID.randomUUID().toString());

		Member member = memberService.getMember(memberId);
		organization.setMembers(Arrays.asList(member));

		organizationRepository.save(organization);

		return organizationRepository.getOne(organization.getId());
	}

	@Transactional
	public void addMember(String organizationId, String memberId) {
		Organization organization = organizationRepository.getOne(organizationId);
		Member member = memberService.getMember(memberId);

		List<Member> members = organization.getMembers();
		members.add(member);

		organizationRepository.save(organization);
	}
}
