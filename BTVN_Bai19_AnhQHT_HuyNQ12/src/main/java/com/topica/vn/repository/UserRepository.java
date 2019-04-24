package com.topica.vn.repository;

import com.topica.vn.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
