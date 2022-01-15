package com.devsuperior.hroauth.service;

import com.devsuperior.hroauth.entities.User;
import com.devsuperior.hroauth.exception.NotFoundException;
import com.devsuperior.hroauth.feignclients.UserFeignClient;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequiredArgsConstructor
@Log4j2
@Service
public class UserService {

    private final UserFeignClient userFeignClient;

    public User findByEmail(String email) {
        User user = userFeignClient.findByEmail(email).getBody();
        if (user == null) {
            log.error("Email not found: {}", email);
            throw new NotFoundException("User not found by email");
        }
        log.info("Email found: {}", email);
        return user;
    }

}
