package com.LLM_test_project.controller;

import com.LLM_test_project.domain.Ou.entity.AdOu;
import com.LLM_test_project.domain.Ou.repository.AdOuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ad-ou")
@RequiredArgsConstructor
public class AdOuRestController {

    private final AdOuRepository adOuRepository;

    @GetMapping("/find-all")
    public List<AdOu> findByUserName() {
        return adOuRepository.findAll();
    }
}
