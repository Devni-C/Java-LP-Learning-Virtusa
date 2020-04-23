package com.devni.tlp.finalproject.userservice.repository;

import com.devni.tlp.finalproject.userservice.model.ERole;
import com.devni.tlp.finalproject.userservice.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(ERole name);
}

