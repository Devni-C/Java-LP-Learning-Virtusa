package com.devni.tlp.finalproject.userservice.repository;

import com.devni.tlp.finalproject.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String nic);
}
