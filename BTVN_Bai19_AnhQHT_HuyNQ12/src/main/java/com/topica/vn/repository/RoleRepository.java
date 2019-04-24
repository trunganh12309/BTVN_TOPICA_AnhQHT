package com.topica.vn.repository;

import com.topica.vn.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByCode(String code);
}
