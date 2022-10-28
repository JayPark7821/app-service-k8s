package kr.perfume.api.core.perfume.fragrance;

import kr.perfume.api.core.perfume.BaseItemDto;
import lombok.Builder;


public class FragranceDto extends BaseItemDto {

    @Builder
    public FragranceDto(Long id, String name, String description) {
        super(id, name, description);
    }
}