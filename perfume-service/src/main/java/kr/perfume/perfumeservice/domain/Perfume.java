package kr.perfume.perfumeservice.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
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

	@JsonManagedReference
	@OneToMany(mappedBy = "perfume", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<FragranceGroup> fragranceGroup = new ArrayList<>();

	@JsonManagedReference
	@OneToMany(mappedBy = "perfume", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PerfumeKeyword> perfumeKeyword = new ArrayList<>();

	public Perfume(Long id, String name, String description, List<FragranceGroup> fragranceGroup,
		List<PerfumeKeyword> perfumeKeyword) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.fragranceGroup = fragranceGroup;
		this.perfumeKeyword = perfumeKeyword;
	}
}
