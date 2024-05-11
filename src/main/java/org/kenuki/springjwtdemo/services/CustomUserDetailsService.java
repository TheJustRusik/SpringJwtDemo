package org.kenuki.springjwtdemo.services;

import lombok.AllArgsConstructor;
import org.kenuki.springjwtdemo.models.enities.User;
import org.kenuki.springjwtdemo.repositories.UserRepository;
import org.kenuki.springjwtdemo.utils.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String nicknameOrEmail) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByNickname(nicknameOrEmail);
        if (user.isEmpty())
            user = userRepository.findByEmail(nicknameOrEmail);

        return user.map(CustomUserDetails::new)
                   .orElseThrow(() -> new UsernameNotFoundException("[" + nicknameOrEmail + "] not found!"));
    }
}
