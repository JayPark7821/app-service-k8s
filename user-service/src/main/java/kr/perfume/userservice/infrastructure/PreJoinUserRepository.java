package kr.perfume.userservice.infrastructure;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.perfume.userservice.domain.PreJoinUser;

public interface PreJoinUserRepository extends JpaRepository<PreJoinUser, String> {

	Optional<PreJoinUser> findPreJoinUserByPreJoinUserIdAndEmail(String preJoinUserId, String email);
}
