package kr.perfume.tempuserservice.repository;

import kr.perfume.tempuserservice.persistence.TempUser;

import java.util.Optional;

public interface TempUserRepository extends JpaRepository<TempUser, Long> {

    Optional<TempUser> findByUserId(String userId);
}
