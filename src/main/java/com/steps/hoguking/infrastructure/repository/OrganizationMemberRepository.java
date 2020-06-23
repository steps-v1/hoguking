package com.steps.hoguking.infrastructure.repository;

import com.steps.hoguking.domain.OrganizationMember;
import com.steps.hoguking.domain.OrganizationMemberId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationMemberRepository extends JpaRepository<OrganizationMember, OrganizationMemberId> {
}
