package com.devni.tlp.finalproject.userservice.service;

import com.devni.tlp.finalproject.userservice.model.User;
import com.devni.tlp.finalproject.userservice.model.UserDTO;

import java.util.List;

public interface UserService {
    User save(UserDTO user) throws Exception;

    List<User> fetchAllUsers();

    User fetchUserById(int id) throws Exception;

    User deleteUser(int id) throws Exception;

    List<User> fetchDeletedUsers();

    List<User> fetchActiveUsers();
}
