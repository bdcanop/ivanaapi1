package com.example.ivanaapi1.Auth;

import com.example.ivanaapi1.User.Role;
import com.example.ivanaapi1.User.User;
import com.example.ivanaapi1.User.UserRepository;
import com.example.ivanaapi1.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final JwtService jwtService;

    public AuthResponse login(LoginRequest loginRequest) {
        return null;
    }

    public AuthResponse register(RegisterRequest registerRequest) {
        User user = User.builder()
                .username(registerRequest.getUsername())
                .password(registerRequest.getPassword())
                .firstName(registerRequest.getFirstName())
                .lastName(registerRequest.getLastName())
                .country(registerRequest.getCountry())
                .role(Role.USER)
                .build();

        userRepository.save(user);
        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();
    }
}
