package com.devni.tlp.finalproject.userservice.repository;

import com.devni.tlp.finalproject.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
