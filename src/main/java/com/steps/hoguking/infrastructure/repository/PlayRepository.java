package com.steps.hoguking.infrastructure.repository;

import com.steps.hoguking.domain.Play;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayRepository extends JpaRepository<Play, String> {
}
