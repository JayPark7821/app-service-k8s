package kr.perfume.api.core.user;

import kr.perfume.api.core.enums.ProviderType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PreJoinUserDto {

	@Getter
	public static class RegisterResponse {
		private String userUuid;
		private String userToken;
		private String username;
		private String email;
		private ProviderType providerType;
		private String profileImageUrl;

		@Builder
		public RegisterResponse(String userUuid, String userToken, String username, String email,
			ProviderType providerType,
			String profileImageUrl) {
			this.userUuid = userUuid;
			this.userToken = userToken;
			this.username = username;
			this.email = email;
			this.providerType = providerType;
			this.profileImageUrl = profileImageUrl;
		}
	}
}