package com.LLM_test_project.domain.ou.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AdOuRepositoryImpl implements AdOuRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

}
