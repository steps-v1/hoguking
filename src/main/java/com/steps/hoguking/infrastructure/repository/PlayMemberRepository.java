package com.steps.hoguking.infrastructure.repository;

import com.steps.hoguking.domain.PlayMember;
import com.steps.hoguking.domain.PlayMemberId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayMemberRepository extends JpaRepository<PlayMember, PlayMemberId> {
}
