package kr.perfume.api.core.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserController {

    @GetMapping("/{email}")
    UserDto getUserByEmail(@PathVariable("email") String email);

    @PostMapping("/user")
    UserDto saveUser(@RequestBody UserDto userDto);

}
