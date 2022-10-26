package kr.perfume.tempuserservice.controller;

import kr.perfume.api.core.tempuser.TempUserController;
import kr.perfume.api.core.tempuser.TempUserDto;
import kr.perfume.tempuserservice.service.TempUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/tempuser")
public class TempUserControllerImpl implements TempUserController {

    private final TempUserService tempUserService;

    @Override
    public TempUserDto forceSaveTempUser(TempUserDto saveRequestDto) {
        return tempUserService.forceSaveTempUser(saveRequestDto);
    }

}
