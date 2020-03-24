package com.devni.tlp.finalproject.userservice.service;

import com.devni.tlp.finalproject.userservice.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user) throws Exception;

    List<User> fetchAllUsers();

    User fetchUserById(int id);
}
