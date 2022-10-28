package kr.perfume.api.core.perfume.keyword;

import kr.perfume.api.core.perfume.BaseItemDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class KeywordDto extends BaseItemDto {

    private KeywordType keywordType;


    @Builder
    public KeywordDto(Long id, String name, String description, KeywordType keywordType) {
        super(id, name, description);
        this.keywordType = keywordType;
    }
}