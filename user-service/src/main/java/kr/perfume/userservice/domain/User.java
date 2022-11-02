package kr.perfume.userservice.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kr.perfume.api.core.enums.ProviderType;
import kr.perfume.api.core.enums.RoleType;
import kr.perfume.utils.TokenGenerator;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "user_table")
public class User {

	private static final String USER_PREFIX = "user_";
	@JsonIgnore
	@Id
	@Column(name = "user_seq")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userSeq;

	private String userToken;

	@Column(name = "user_id", length = 64, unique = true)
	@NotNull
	@Size(max = 64)
	private String userId;

	@Column(name = "username", length = 100)
	@NotNull
	@Size(max = 100)
	private String username;

	@JsonIgnore
	@Column(name = "password", length = 128)
	@NotNull
	@Size(max = 128)
	private String password;

	@Column(name = "email", length = 512, unique = true)
	@NotNull
	@Size(max = 512)
	private String email;

	@Column(name = "email_verified_yn", length = 1)
	@NotNull
	@Size(min = 1, max = 1)
	private String emailVerifiedYn;

	@Column(name = "profile_image_url", length = 512)
	@Size(max = 512)
	private String profileImageUrl;

	@Column(name = "provider_type", length = 20)
	@Enumerated(EnumType.STRING)
	private ProviderType providerType;

	@Column(name = "role_type", length = 20)
	@Enumerated(EnumType.STRING)
	@NotNull
	private RoleType roleType;

	@Builder
	public User(String userId, String username, String password, String email, String emailVerifiedYn, String userToken,
		String profileImageUrl, ProviderType providerType, RoleType roleType) {

		this.userId = userId;
		this.userToken = TokenGenerator.randomCharacterWithPrefix(USER_PREFIX);
		this.username = username;
		this.password = TokenGenerator.randomCharacter(20);
		this.email = email;
		this.emailVerifiedYn = emailVerifiedYn;
		this.profileImageUrl = profileImageUrl;
		this.providerType = providerType;
		this.roleType = roleType;
	}

}
