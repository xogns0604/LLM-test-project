package com.LLM_test_project.controller;

import com.LLM_test_project.service.ou.AdOuService;
import com.LLM_test_project.service.ou.AdOuTreeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ad-ou")
@RequiredArgsConstructor
public class AdOuRestController {

    private final AdOuService adOuService;

    @PostMapping(value = "/tree/{vcenterInfraId}")
    public List<AdOuTreeDto> findOuTreeByLocationAndInfraId(@PathVariable("vcenterInfraId") Long vcenterInfraId) {
        return adOuService.findOuTreeByVcenterInfraId(vcenterInfraId);
    }
}
