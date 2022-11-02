package kr.perfume.userservice.domain;

import kr.perfume.api.core.enums.ProviderType;
import kr.perfume.api.core.enums.RoleType;
import kr.perfume.api.core.user.UserDto;
import lombok.Getter;
import lombok.ToString;

public class UserInfo {

	@Getter
	@ToString
	public static class Main {
		private final Long userSeq;

		private final String userId;

		private final String username;

		private final String email;

		private final String emailVerifiedYn;

		private final String profileImageUrl;

		private final ProviderType providerType;

		private final RoleType roleType;
		private final String userToken;

		public Main(User user) {
			this.userSeq = user.getUserSeq();
			this.userId = user.getUserId();
			this.username = user.getUsername();
			this.email = user.getEmail();
			this.emailVerifiedYn = user.getEmailVerifiedYn();
			this.profileImageUrl = user.getProfileImageUrl();
			this.providerType = user.getProviderType();
			this.roleType = user.getRoleType();
			this.userToken = user.getUserToken();
		}

		public UserDto.UserResponse toResponse() {
			return UserDto.UserResponse.builder()
				.userToken(this.userToken)
				.profileImage(this.profileImageUrl)
				.email(this.email)
				.userId(this.userId)
				.providerType(this.providerType)
				.roleType(this.roleType)
				.name(this.username)
				.build();
		}
	}

	@Getter
	public static class LoginInfo {
		private String tempUserId;
		private String userToken;
		private String email;
		private String name;
		private ProviderType providerType;
		private RoleType roleType;
		private String profileImage;
		private String accessToken;
		private String refreshToken;

		public LoginInfo(User user, String accessToken, String refreshToken) {
			this.userToken = user.getUserToken();
			this.email = user.getEmail();
			this.name = user.getUsername();
			this.providerType = user.getProviderType();
			this.roleType = user.getRoleType();
			this.profileImage = user.getProfileImageUrl();
			this.accessToken = accessToken;
			this.refreshToken = refreshToken;
		}

		public LoginInfo(PreJoinUser user) {
			this.tempUserId = getTempUserId();
			this.email = user.getEmail();
			this.name = user.getUsername();
			this.providerType = user.getProviderType();
			this.profileImage = user.getProfileImageUrl();
		}

		public UserDto.LoginResponse toResponse() {
			return UserDto.LoginResponse.builder()
				.userUuid(this.tempUserId)
				.userToken(this.userToken)
				.username(this.name)
				.email(this.email)
				.providerType(this.providerType)
				.profileImageUrl(this.profileImage)
				.build();
		}
	}

}
