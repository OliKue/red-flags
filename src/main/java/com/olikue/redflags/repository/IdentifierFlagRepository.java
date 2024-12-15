package com.olikue.redflags.repository;

import com.olikue.redflags.model.IdentifierFlag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IdentifierFlagRepository extends JpaRepository<IdentifierFlag, UUID> {}
