package kr.perfume.api.core.perfume;

import lombok.Builder;
import lombok.Getter;

@Getter
public class BaseItemDto {
    private Long id;
    private String name;
    private String description;


    public BaseItemDto(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
