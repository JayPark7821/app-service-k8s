package kr.perfume.api.core.perfume.perfume;

import kr.perfume.api.core.perfume.BaseItemDto;
import lombok.Builder;

public class PerfumeDto extends BaseItemDto {

    @Builder
    public PerfumeDto(Long id, String name, String description) {
        super(id, name, description);
    }
}