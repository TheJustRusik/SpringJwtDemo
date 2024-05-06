package org.kenuki.springjwtdemo.repositories;

import org.kenuki.springjwtdemo.models.enities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
