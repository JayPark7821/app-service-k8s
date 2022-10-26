package kr.perfume.tempuserservice.controller;

import kr.perfume.tempuserservice.service.TempUserService;
import lombok.RequiredArgsConstructor;

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
