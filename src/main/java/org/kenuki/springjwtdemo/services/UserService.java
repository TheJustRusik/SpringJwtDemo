package org.kenuki.springjwtdemo.services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.kenuki.springjwtdemo.controller.SecurityController;
import org.kenuki.springjwtdemo.models.dtos.LoginDTO;
import org.kenuki.springjwtdemo.models.dtos.RegisterDTO;
import org.kenuki.springjwtdemo.models.enities.Role;
import org.kenuki.springjwtdemo.models.enities.User;
import org.kenuki.springjwtdemo.repositories.RoleRepository;
import org.kenuki.springjwtdemo.repositories.UserRepository;
import org.kenuki.springjwtdemo.utils.JwtTokenUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final JwtTokenUtils jwtTokenUtils;
    private final PasswordEncoder passwordEncoder;
    public String register(RegisterDTO registerDTO) {
        User newUser = new User();
        newUser.setNickname(registerDTO.getUsername());
        newUser.setEmail(registerDTO.getEmail());
        newUser.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        newUser.setRoles(Set.of(roleRepository.findById(1L).orElseThrow()));
        userRepository.save(newUser);
        return login(newUser.getEmail(), newUser.getPassword());

    }
    public String login(LoginDTO loginDTO) {
        return login(loginDTO.getEmail(), loginDTO.getPassword());
    }
    private String login(String email, String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password)
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return jwtTokenUtils.generateToken(authentication, userRepository.findByNicknameOrEmail(email, email).orElseThrow().getRoles().stream().map());
    }

}
