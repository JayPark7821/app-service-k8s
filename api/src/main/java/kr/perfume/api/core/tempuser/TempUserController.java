package kr.perfume.api.core.tempuser;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface TempUserController {

    @PostMapping("/force-save")
    TempUserDto forceSaveTempUser(@RequestBody TempUserDto tempUserDto);
}
