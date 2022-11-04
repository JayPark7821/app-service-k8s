package kr.perfume.api.core.user;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import kr.perfume.api.core.enums.ProviderType;
import kr.perfume.api.core.enums.RoleType;
import lombok.Builder;
import lombok.Getter;

public class UserDto {

	@Getter
	public static class UserResponse {
		private String userToken;
		private String userId;
		private String email;
		private String name;
		private ProviderType providerType;
		private RoleType roleType;
		private String profileImage;

		@Builder
		public UserResponse(String userToken, String userId, String email, String name, ProviderType providerType,
			RoleType roleType, String profileImage) {
			this.userToken = userToken;
			this.userId = userId;
			this.email = email;
			this.name = name;
			this.providerType = providerType;
			this.roleType = roleType;
			this.profileImage = profileImage;
		}
	}

	@Getter
	public static class LoginResponse {
		private String userUuid;
		private String userToken;
		private String username;
		private String email;
		private ProviderType providerType;
		private String profileImageUrl;

		@Builder
		public LoginResponse(String userUuid, String userToken, String username, String email,
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

	@Getter
	public static class JoinRequest {
		@Valid
		@NotNull(message = "임시 유저ID는 필수 값입니다.")
		private String preJoinUserId;

		@Valid
		@NotNull(message = "사용자 이름은 필수 값입니다.")
		@Size(min = 1, max = 100)
		private String name;

		@Valid
		@NotNull(message = "사용자 email은 필수 값입니다.")
		@Size(max = 512)
		@Email
		private String email;

	}

}
