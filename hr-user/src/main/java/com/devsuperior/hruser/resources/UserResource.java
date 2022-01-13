package com.devsuperior.hruser.resources;

import javax.ws.rs.QueryParam;

import com.devsuperior.hruser.entities.User;
import com.devsuperior.hruser.repositories.UserRepository;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RefreshScope
@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
public class UserResource {

    private final UserRepository repository;

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User obj = repository.findById(id).get();
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping("/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email) {
        User obj = repository.findByEmail(email);
        return ResponseEntity.ok().body(obj);
    }
}
