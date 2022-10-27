package kr.perfume.api.core.keyword;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class KeywordDto {

    private Long id;
    private String name;
    private String description;
    private KeywordType keywordType;

    @Builder
    public KeywordDto(Long id, String name, String description, KeywordType keywordType) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.keywordType = keywordType;
    }
}