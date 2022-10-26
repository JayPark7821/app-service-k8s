package kr.perfume.api.core.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface UserController {

    @GetMapping("/{email}")
    UserDto getUserByEmail(@PathVariable("email") String email);
}
