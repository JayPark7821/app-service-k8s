package kr.perfume.api.core.perfume.keyword;

import lombok.Getter;

public class KeywordDto {

	@Getter
	public static class KeywordResponse {

		private final Long id;
		private final String name;
		private final String description;
		private KeywordType keywordType;

		public KeywordResponse(Long id, String name, String description, KeywordType keywordType) {
			this.id = id;
			this.name = name;
			this.description = description;
			this.keywordType = keywordType;
		}
	}

	@Getter
	public static class KeywordGroupResponse {

		private final Long id;
		private final String name;
		private final String description;
		private KeywordType keywordType;

		public KeywordGroupResponse(Long id, String name, String description, KeywordType keywordType) {
			this.id = id;
			this.name = name;
			this.description = description;
			this.keywordType = keywordType;
		}
	}

}