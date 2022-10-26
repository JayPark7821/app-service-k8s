package kr.perfume.api.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum ProviderType {
	GOOGLE("GOOGLE","google"),
	APPLE("APPLE","apple"),
	LOCAL("LOCAL","local");

	private final String code;
	private final String displayName;

	public static ProviderType of(String code) {
		return Arrays.stream(ProviderType.values())
			.filter(r -> r.getCode().equals(code))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException("지원하지 않는 소셜 타입입니다."));
	}
}
