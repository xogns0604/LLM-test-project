package com.LLM_test_project.domain.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {

    @Id
    private Long id;
    private String name;
    private String phoneNumber;
}
