package kr.perfume.perfumeservice.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class FragranceGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fragrance_group_id")
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "perfume_id")
	private Perfume perfume;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fragrance_id")
	private Fragrance fragrance;

	private int containPercentage;

	@Builder
	public FragranceGroup(Long id, Perfume perfume, Fragrance fragrance, int containPercentage) {
		this.id = id;
		this.perfume = perfume;
		this.fragrance = fragrance;
		this.containPercentage = containPercentage;
	}

	public void setPerfumeRelation(Perfume perfume) {
		this.perfume = perfume;
	}

}
