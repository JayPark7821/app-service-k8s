package kr.perfume.api.core.perfume.perfume;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import kr.perfume.api.core.perfume.fragrance.FragranceDto;
import lombok.Getter;

public class PerfumeDto {

	@Getter
	public static class PerfumeRequest {
		private Long id;
		private String name;
		private String description;

		@Valid
		@NotNull
		private List<FragranceDto.FragranceGroupResponse> fragranceList;

	}
}