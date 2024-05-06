package org.kenuki.springjwtdemo.repositories;

import org.kenuki.springjwtdemo.models.enities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByNicknameOrEmail(String nickname, String email);
}
