package kr.perfume.userservice.infrastructure;

import org.springframework.stereotype.Component;

import kr.perfume.userservice.domain.PreJoinUser;
import kr.perfume.userservice.domain.sotre.PreJoinUserStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class PreJoinUserStoreImpl implements PreJoinUserStore {

	private final PreJoinUserRepository preJoinUserRepository;

	@Override
	public PreJoinUser store(PreJoinUser user) {
		return preJoinUserRepository.save(user);
	}
}
