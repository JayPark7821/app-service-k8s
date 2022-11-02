package kr.perfume.userservice.domain.reader;

import java.util.Optional;

import kr.perfume.userservice.domain.User;

public interface UserReader {
	User getUserByUserToken(String userToken);

	Optional<User> findUserByEmail(String email);
}
