package com.LLM_test_project.domain.Ou.repository;

import com.LLM_test_project.domain.Ou.entity.AdOu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdOuRepository extends JpaRepository<AdOu, Long> {
}