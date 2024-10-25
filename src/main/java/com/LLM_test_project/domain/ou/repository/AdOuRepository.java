package com.LLM_test_project.domain.ou.repository;

import com.LLM_test_project.domain.ou.entity.AdOu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdOuRepository extends JpaRepository<AdOu, Long>, AdOuRepositoryCustom {
    List<AdOu> findByVdiInfraId(Long adInfraId);
}