package kr.perfume.userservice.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import kr.perfume.api.core.enums.ProviderType;
import kr.perfume.api.core.enums.RoleType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "prejoin_user")
public class PreJoinUser {

	@Id
	@Column(name = "prejoinuser_id")
	private String preJoinUserId;

	@Column(name = "user_id", length = 64, unique = true)
	@NotNull
	@Size(max = 64)
	private String userId;

	@Column(name = "username", length = 100)
	@NotNull
	@Size(max = 100)
	private String username;

	@Column(name = "email", length = 512, unique = true)
	@NotNull
	@Size(max = 512)
	private String email;

	@Column(name = "provider_type", length = 20)
	@Enumerated(EnumType.STRING)
	private ProviderType providerType;

	@Column(name = "profile_image_url", length = 512)
	@Size(max = 512)
	private String profileImageUrl;

	@Builder
	public PreJoinUser(String preJoinUserId, String userId, String username, String email, ProviderType providerType,
		String profileImageUrl) {
		this.preJoinUserId = preJoinUserId;
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.providerType = providerType;
		this.profileImageUrl = profileImageUrl;
	}

	public User toUser() {
		return User.builder()
			.userId(this.userId)
			.username(this.username)
			.email(this.email)
			.emailVerifiedYn("Y")
			.profileImageUrl(this.profileImageUrl)
			.providerType(this.providerType)
			.roleType(RoleType.USER)
			.build();
	}

}