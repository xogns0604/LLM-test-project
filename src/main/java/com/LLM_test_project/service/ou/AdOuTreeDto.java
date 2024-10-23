package com.LLM_test_project.service.ou;

import com.LLM_test_project.domain.ou.entity.AdOu;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
public class AdOuTreeDto {

    private String distinguishedName;
    private String name;
    @Builder.Default
    private List<AdOuTreeDto> children = new ArrayList<>();

    public static AdOuTreeDto toDto(AdOu ou) {
        return AdOuTreeDto.builder()
                .distinguishedName(ou.getDn())
                .name(ou.getOuName())
                .build();
    }

    public void addChild(AdOuTreeDto ou) {
        children.add(ou);
    }
}
