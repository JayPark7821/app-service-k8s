package kr.perfume.userservice.domain.reader;

import java.util.Optional;

import kr.perfume.userservice.domain.PreJoinUser;

public interface PreJoinUserReader {

	Optional<PreJoinUser> findPreJoinUserByUuidAndEmail(String uuid, String email);
}
