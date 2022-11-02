package kr.perfume.userservice.domain.sotre;

import kr.perfume.userservice.domain.User;

public interface UserStore {
	User store(User user);
}
