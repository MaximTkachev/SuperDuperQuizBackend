package com.hits.superduperquizbackend.controller;

import com.hits.superduperquizbackend.DTO.account.ChangePasswordDTO;
import com.hits.superduperquizbackend.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {

    private final AccountService userService;

    @PatchMapping("/password")
    public ResponseEntity<?> changePassword(Authentication authentication, @Validated @RequestBody ChangePasswordDTO dto) {
        return userService.changePassword(authentication, dto);
    }
}
