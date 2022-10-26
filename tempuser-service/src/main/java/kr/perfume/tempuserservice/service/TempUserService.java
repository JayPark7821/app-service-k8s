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
        Optional<TempUser> tempUser = tempUserRepository.findByUserId(saveRequestDto.getUserId());
        if (tempUser.isPresent()) {
            tempUser.get().updateTempUser(saveRequestDto);
            return saveRequestDto;
        }else{
            TempUser savedTempUser = tempUserRepository.save(new TempUser(saveRequestDto));
            return savedTempUser.toDto();
        }
    }

    public TempUserDto getTempUserByTempUserId(String tempUserId) {
        return tempUserRepository.findById(tempUserId).map(TempUser::toDto).orElse(null);
    }
}
