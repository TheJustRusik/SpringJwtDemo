package org.kenuki.springjwtdemo.repositories;

import org.kenuki.springjwtdemo.models.enities.Role;
import org.kenuki.springjwtdemo.models.enities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByNickname(String nickname);
    Optional<User> findByEmail(String email);
}
