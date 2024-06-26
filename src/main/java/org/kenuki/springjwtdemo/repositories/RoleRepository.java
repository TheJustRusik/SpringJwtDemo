package org.kenuki.springjwtdemo.repositories;

import org.kenuki.springjwtdemo.models.enities.Role;
import org.kenuki.springjwtdemo.models.enities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
