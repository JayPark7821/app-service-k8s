package kr.perfume.userservice.infrastructure.auth.user;

import java.util.Map;

import kr.perfume.api.composite.auth.OAuth2UserInfo;

public class LocalUserInfo extends OAuth2UserInfo {

	public LocalUserInfo(Map<String, Object> attributes) {
		super(attributes);
	}

	@Override
	public String getId() {
		return (String)attributes.get("id");
	}

	@Override
	public String getName() {
		return (String)attributes.get("name");
	}

	@Override
	public String getEmail() {
		return (String)attributes.get("email");
	}

	@Override
	public String getImageUrl() {
		return (String)attributes.get("picture");
	}
}
