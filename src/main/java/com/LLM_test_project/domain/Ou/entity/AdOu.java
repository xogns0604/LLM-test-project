package com.LLM_test_project.domain.Ou.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "ad_ou")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AdOu {

    @Id
    @Column(name = "distinguishedName")
    private String dn;
    private String ouName;
    private Long vdiInfraId;
    private String description;

}