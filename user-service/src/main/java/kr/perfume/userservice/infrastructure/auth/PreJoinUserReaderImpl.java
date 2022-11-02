package kr.perfume.userservice.infrastructure.auth;

import java.util.Optional;

import org.springframework.stereotype.Component;

import kr.perfume.userservice.domain.PreJoinUser;
import kr.perfume.userservice.domain.reader.PreJoinUserReader;
import kr.perfume.userservice.infrastructure.PreJoinUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class PreJoinUserReaderImpl implements PreJoinUserReader {

	private final PreJoinUserRepository preJoinUserRepository;

	@Override
	public Optional<PreJoinUser> findPreJoinUserByUuidAndEmail(String uuid, String email) {
		return preJoinUserRepository.findById(uuid);
	}
}
