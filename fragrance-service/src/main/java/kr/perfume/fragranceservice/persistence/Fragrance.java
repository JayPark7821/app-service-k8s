package kr.perfume.fragranceservice.persistence;


import com.fasterxml.jackson.annotation.JsonIgnore;
import kr.perfume.api.core.perfume.BaseItemDto;
import kr.perfume.api.core.perfume.fragrance.FragranceDto;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "fragrance")
public class Fragrance {

    @JsonIgnore
    @Id
    @Column(name = "fragrance_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fragrance_name", length = 50, unique = true)
    @NotNull
    @Size(max = 50)
    private String name;

    @Column(name = "fragrance_desc", length = 100)
    @NotNull
    @Size(max = 100)
    private String description;

    @Builder
    public Fragrance(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Fragrance(BaseItemDto dto) {
        this.id = dto.getId();
        this.name = dto.getName();
        this.description = dto.getDescription();
    }
    public FragranceDto toDto() {
        return FragranceDto.builder()
                .id(this.id)
                .name(this.name)
                .description(this.description)
                .build();
    }

}
