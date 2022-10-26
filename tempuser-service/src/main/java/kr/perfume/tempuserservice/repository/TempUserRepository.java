package kr.perfume.tempuserservice.repository;

import kr.perfume.tempuserservice.persistence.TempUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TempUserRepository extends JpaRepository<TempUser, Long> {

    Optional<TempUser> findByUserId(String userId);
}
