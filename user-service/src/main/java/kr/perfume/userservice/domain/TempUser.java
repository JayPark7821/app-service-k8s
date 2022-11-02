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
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "temp_user")
public class TempUser {

	@Id
	@Column(name = "user_uuid")
	private String userUuid;

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
	public TempUser(String userUuid, String userId, String username, String email, ProviderType providerType,
		String profileImageUrl) {
		this.userUuid = userUuid;
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.providerType = providerType;
		this.profileImageUrl = profileImageUrl;
	}
}