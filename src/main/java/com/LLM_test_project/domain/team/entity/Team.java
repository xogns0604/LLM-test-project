package com.LLM_test_project.domain.team.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Team {

    @Id
    private Long id;
    private String name;
}
