package kr.perfume.api.core.tempuser;

import kr.perfume.api.core.enums.ProviderType;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TempUserDto {

	private String userUuid;
	private String userId;
	private String username;
	private String email;
	private ProviderType providerType;
	private String profileImageUrl;

}