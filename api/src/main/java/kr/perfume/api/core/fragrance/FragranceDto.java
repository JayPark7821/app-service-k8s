package kr.perfume.api.core.fragrance;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FragranceDto {

    private Long id;
    private String name;
    private String description;

    @Builder
    public FragranceDto(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

}