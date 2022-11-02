package kr.perfume.userservice.infrastructure;

import org.springframework.stereotype.Component;

import kr.perfume.userservice.domain.User;
import kr.perfume.userservice.domain.sotre.UserStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserStoreImpl implements UserStore {

	private final UserRepository userRepository;

	@Override
	public User store(User user) {
		return userRepository.save(user);
	}

}
