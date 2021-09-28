package com.security.springbootsecurity.repository;

import com.security.springbootsecurity.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    public Role findByName(String name);
}
