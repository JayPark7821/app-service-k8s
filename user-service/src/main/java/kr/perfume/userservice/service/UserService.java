package kr.perfume.userservice.service;

import kr.perfume.api.core.user.UserDto;
import kr.perfume.userservice.persistence.User;
import kr.perfume.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserDto getUserByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        return user.map(User::toDto).orElse(null);
    }
}
