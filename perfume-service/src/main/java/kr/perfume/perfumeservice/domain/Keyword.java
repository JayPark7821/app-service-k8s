package kr.perfume.perfumeservice.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import kr.perfume.api.core.perfume.keyword.KeywordType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "keyword")
public class Keyword {

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
}
