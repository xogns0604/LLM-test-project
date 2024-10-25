package com.LLM_test_project.service.ou;

import com.LLM_test_project.domain.ou.repository.AdOuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdOuTreeService {

    private final AdOuRepository adOuRepository;

    public List<AdOuTreeDto> findOuTreeByInfraId(Long adInfraId) {
        List<AdOuTreeDto> ouDtos = getAdOuTreeDtosByInfraId(adInfraId);
        return buildOuTree(ouDtos);
    }

    private List<AdOuTreeDto> getAdOuTreeDtosByInfraId(Long adInfraId) {
        return adOuRepository.findByVdiInfraId(adInfraId).stream()
                .map(AdOuTreeDto::toDto)
                .collect(Collectors.toList());
    }

    private List<AdOuTreeDto> buildOuTree(List<AdOuTreeDto> ous) {
        Map<String, AdOuTreeDto> ouMap = ous.stream()
                .collect(Collectors.toMap(AdOuTreeDto::getDistinguishedName, ou -> ou));

        List<AdOuTreeDto> rootOUs = new ArrayList<>();

        for (AdOuTreeDto ou : ous) {
            if (isRootOu(ou)) {
                rootOUs.add(ou);
            } else {
                addToParent(ou, ouMap, rootOUs);
            }
        }

        sortOUsRecursively(rootOUs);
        return rootOUs;
    }

    private boolean isRootOu(AdOuTreeDto ou) {
        String[] parts = ou.getDistinguishedName().split(",");
        return parts.length == 1 || !parts[1].startsWith("OU=");
    }

    private void addToParent(AdOuTreeDto ou, Map<String, AdOuTreeDto> ouMap, List<AdOuTreeDto> rootOUs) {
        String parentDN = extractParentDN(ou.getDistinguishedName());
        AdOuTreeDto parentOu = ouMap.get(parentDN);

        if (parentOu != null) {
            parentOu.addChild(ou);
        } else {
            rootOUs.add(ou);
        }
    }

    private String extractParentDN(String distinguishedName) {
        return distinguishedName.substring(distinguishedName.indexOf(",") + 1);
    }

    private void sortOUsRecursively(List<AdOuTreeDto> ous) {
        ous.sort(Comparator.comparing(AdOuTreeDto::getName));
        ous.forEach(ou -> sortOUsRecursively(ou.getChildren()));
    }
}