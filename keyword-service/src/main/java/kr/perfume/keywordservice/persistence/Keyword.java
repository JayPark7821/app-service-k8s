package kr.perfume.keywordservice.persistence;


import com.fasterxml.jackson.annotation.JsonIgnore;
import kr.perfume.api.core.fragrance.FragranceDto;
import kr.perfume.api.core.keyword.KeywordDto;
import kr.perfume.api.core.keyword.KeywordType;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "keyword")
public class Keyword {

    @JsonIgnore
    @Id
    @Column(name = "keyword_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "keyword_name", length = 50, unique = true)
    @NotNull
    @Size(max = 50)
    private String name;

    @Column(name = "keyword_desc", length = 100)
    @NotNull
    @Size(max = 100)
    private String description;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private KeywordType keywordType;


    @Builder
    public Keyword(Long id, String name, String description, KeywordType keywordType) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.keywordType = keywordType;
    }

    public Keyword(KeywordDto dto) {
        this.id = dto.getId();
        this.name = dto.getName();
        this.description = dto.getDescription();
        this.keywordType = dto.getKeywordType();
    }

    public KeywordDto toDto() {
        return KeywordDto.builder()
                .id(this.id)
                .name(this.name)
                .description(this.description)
                .keywordType(this.keywordType)
                .build();
    }

}
