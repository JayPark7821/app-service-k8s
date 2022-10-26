package kr.perfume.tempuserservice.service;

import kr.perfume.api.core.tempuser.TempUserDto;
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

    public TempUserDto forceSaveTempUser(TempUserDto saveRequestDto) {
        Optional<TempUser> user = tempUserRepository.findByUserId(saveRequestDto.getUserId());
        return null;
    }
}
