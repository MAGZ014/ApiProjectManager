package com.projectmanager.projectmanager.controller;

import com.projectmanager.projectmanager.dto.AuthRequestDTO;
import com.projectmanager.projectmanager.dto.AuthResponseDTO;
import com.projectmanager.projectmanager.service.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import com.projectmanager.projectmanager.model.User;


@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authManager;
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    public AuthController(AuthenticationManager authManager, JwtService jwtService,
                          UserDetailsService userDetailsService) {
        this.authManager = authManager;
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }
    @PostMapping("/login")
    public AuthResponseDTO login(@RequestBody AuthRequestDTO request) {
        try {
            authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
            );

            var user  = (User) userDetailsService.loadUserByUsername(request.getEmail());

            return new AuthResponseDTO(
                    jwtService.generateToken(user.getEmail()),
                    jwtService.generateRefreshToken(user.getEmail()),
                    user.getName(),
                    user.getEmail(),
                    user.getRole().getRol()
            );

        } catch (AuthenticationException e) {
            throw new RuntimeException("Credenciales inválidas");
        }
    }

}
