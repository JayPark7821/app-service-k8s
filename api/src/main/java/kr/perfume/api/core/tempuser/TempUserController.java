package kr.perfume.api.core.tempuser;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface TempUserController {

    @PostMapping("/force-save")
    TempUserDto forceSaveTempUser(@RequestBody TempUserDto tempUserDto);

    @GetMapping("/tempuser/{tempUserId}")
    TempUserDto getTempUserByTempUserId(@PathVariable("tempUserId") String tempUserId);
}
