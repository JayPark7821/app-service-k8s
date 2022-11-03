package kr.perfume.api.core.perfume.fragrance;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Builder;
import lombok.Getter;

public class FragranceDto {

	@Getter
	public static class FragranceResponse {
		private final Long id;
		private final String name;
		private final String description;

		@Builder
		public FragranceResponse(Long id, String name, String description) {
			this.id = id;
			this.name = name;
			this.description = description;
		}
	}

	@Getter
	public static class FragranceGroupResponse {
		private final Long id;
		private final String name;
		private final String description;
		private final double percentage;

		@Builder
		public FragranceGroupResponse(Long id, String name, String description, double percentage) {
			this.id = id;
			this.name = name;
			this.description = description;
			this.percentage = percentage;
		}
	}

	public static class FragranceRequest {
		private final Long id;

		@Valid
		@NotNull
		@Size(max = 50, message = "명칭은 50 자보다 클 수 없습니다.")
		private final String name;

		@Valid
		@NotNull
		@Size(max = 200, message = "상세정보는 200 자보다 클 수 없습니다.")
		private final String description;

		@Builder
		public FragranceRequest(Long id, String name, String description) {
			this.id = id;
			this.name = name;
			this.description = description;
		}
	}

	@Getter
	public static class FragranceGroupSaveRequest {

		@Valid
		@NotNull
		private final Long id;

		@Valid
		@NotNull
		private final int percentage;

		@Builder
		public FragranceGroupSaveRequest(Long id, int percentage) {
			this.id = id;
			this.percentage = percentage;
		}
	}

}