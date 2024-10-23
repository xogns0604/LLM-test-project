package com.LLM_test_project.service.ou;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdOuService {

    private final AdOuTreeService adOuTreeService;

    public List<AdOuTreeDto> findOuTreeByVcenterInfraId(Long vcenterInfraId) {
        return adOuTreeService.findOuTreeByInfraId(vcenterInfraId);
    }
}
