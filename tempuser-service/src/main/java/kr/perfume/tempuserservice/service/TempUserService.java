package kr.perfume.tempuserservice.service;

import kr.perfume.tempuserservice.persistence.TempUser;
import kr.perfume.tempuserservice.repository.TempUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TempUserService {

    private final TempUserRepository tempUserRepository;

    public TempUserDto forceSaveTempUser(String email) {
        Optional<TempUser> user = tempUserRepository.findByUserId(email);
        return null;
    }
}
