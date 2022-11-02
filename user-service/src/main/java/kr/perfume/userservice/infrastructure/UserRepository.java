package kr.perfume.userservice.infrastructure;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.perfume.userservice.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUserToken(String userToken);

	Optional<User> findByEmail(String email);
}
