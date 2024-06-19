package com.aluraLatam.foroHubChallenge.controller;

import com.aluraLatam.foroHubChallenge.domain.user.User;
import com.aluraLatam.foroHubChallenge.domain.user.UserData;
import com.aluraLatam.foroHubChallenge.infra.security.DataJWTToken;
import com.aluraLatam.foroHubChallenge.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager; // Spring's AuthenticationManager for user authentication

    @Autowired
    private TokenService tokenService;

    /**
     * Endpoint for user authentication. Generates JWT token upon successful authentication.
     * @param userData User data containing username and password.
     * @return ResponseEntity containing JWT token.
     */
    @PostMapping // Use POST method for authentication
    public ResponseEntity userAuthentication(@RequestBody @Valid UserData userData) {
        // Create authentication token with provided username and password
           Authentication aUtoken = new UsernamePasswordAuthenticationToken(userData.username(),userData.password());
        // Authenticate user using AuthenticationManager
            var authenticadedUser = authenticationManager.authenticate(aUtoken);
        // Generate JWT token for the authenticated user
            var token= tokenService.generateToken((User) authenticadedUser.getPrincipal());
        // Return JWT token in response body
            return ResponseEntity.ok(new DataJWTToken(token));
        }
    }
