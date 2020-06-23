package com.steps.hoguking.infrastructure.repository;

import com.steps.hoguking.domain.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token, String> {
}
