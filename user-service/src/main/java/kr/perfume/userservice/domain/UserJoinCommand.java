package kr.perfume.userservice.domain;

import kr.perfume.api.core.user.UserDto;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UserJoinCommand {
	private final String preJoinUserId;
	private final String name;
	private final String email;

	@Builder
	public UserJoinCommand(String preJoinUserId, String name, String email) {
		this.preJoinUserId = preJoinUserId;
		this.name = name;
		this.email = email;
	}

	public UserJoinCommand(UserDto.JoinRequest joinRequest) {
		this.preJoinUserId = joinRequest.getPreJoinUserId();
		this.name = joinRequest.getName();
		this.email = joinRequest.getEmail();
	}
}
