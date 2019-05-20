package com.movie.movie.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor

public class UserController {

    private final UserService userService;

    @DeleteMapping("/api/me")
    public void removeAccount() {
        userService.removeAccount();
    }
}
