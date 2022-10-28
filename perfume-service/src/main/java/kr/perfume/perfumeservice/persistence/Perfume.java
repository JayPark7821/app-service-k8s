package kr.perfume.perfumeservice.persistence;


import kr.perfume.api.core.perfume.BaseItemDto;
import kr.perfume.api.core.perfume.fragrance.FragranceDto;
import kr.perfume.api.core.perfume.perfume.PerfumeDto;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "perfume")
public class Perfume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "perfume_id")
    private Long id;

    @Column(name = "perfume_name")
    private String name;

    @Column(name = "perfume_desc")
    private String description;

    public Perfume(BaseItemDto baseItemDto) {
        this.id = baseItemDto.getId();
        this.name = baseItemDto.getName();
        this.description = baseItemDto.getDescription();
    }

    public PerfumeDto toDto() {
        return PerfumeDto.builder()
                .id(this.id)
                .name(this.name)
                .description(this.description)
                .build();
    }

}
