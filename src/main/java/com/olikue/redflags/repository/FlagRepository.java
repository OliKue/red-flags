package com.olikue.redflags.repository;

import com.olikue.redflags.model.Flag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FlagRepository extends JpaRepository<Flag, UUID> {}
