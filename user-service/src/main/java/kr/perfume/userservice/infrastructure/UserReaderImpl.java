package kr.perfume.userservice.infrastructure;

import java.util.Optional;

import org.springframework.stereotype.Component;

import kr.perfume.userservice.domain.User;
import kr.perfume.userservice.domain.reader.UserReader;
import kr.perfume.utils.enums.ErrorCode;
import kr.perfume.utils.exception.PerfumeApplicationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserReaderImpl implements UserReader {

	private final UserRepository userRepository;

	@Override
	public User getUserByUserToken(String userToken) {
		return userRepository.findByUserToken(userToken)
			.orElseThrow(() -> new PerfumeApplicationException(ErrorCode.USER_NOT_FOUND));
	}

	@Override
	public Optional<User> findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
}
