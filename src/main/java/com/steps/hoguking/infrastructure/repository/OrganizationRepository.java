package com.steps.hoguking.infrastructure.repository;

import com.steps.hoguking.domain.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization, String> {
}
