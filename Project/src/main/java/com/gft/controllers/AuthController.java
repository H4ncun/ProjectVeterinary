package com.gft.controllers;

import com.gft.dto.authSystemDTO.AuthDTO;
import com.gft.dto.authSystemDTO.TokenDTO;
import com.gft.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private AuthService authService;
    private final AuthenticationManager authenticationManager;

    public AuthController(AuthService authService, AuthenticationManager authenticationManager) {
        this.authService = authService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping
    public ResponseEntity<TokenDTO> auth(@RequestBody AuthDTO authForm) {
        Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authForm.getEmail(), authForm.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(auth);
        String token = authService.createToken(auth);
        return ResponseEntity.ok(new TokenDTO(token));
    }
}
