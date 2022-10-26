package kr.perfume.userservice.controller;

import kr.perfume.api.core.user.UserController;
import kr.perfume.api.core.user.UserDto;
import kr.perfume.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserControllerImpl implements UserController {

    private final UserService userService;

    @Override
    public UserDto getUserByEmail(String email) {
        return userService.getUserByEmail(email);
    }

    @Override
    public UserDto saveUser(UserDto userDto) {
        return userService.saveUser(userDto);
    }

}
