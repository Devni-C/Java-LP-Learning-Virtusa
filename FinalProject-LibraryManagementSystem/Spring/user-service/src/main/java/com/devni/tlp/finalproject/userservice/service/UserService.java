package com.devni.tlp.finalproject.userservice.service;

import com.devni.tlp.finalproject.userservice.model.User;

import java.util.List;

public interface UserService {
//    User updateUser(User user) throws Exception, UserExistException;

    List<User> fetchAllUsers();

    User fetchUserById(int id) throws Exception;

    User deleteUser(int id) throws Exception;

    List<User> fetchDeletedUsers();

    List<User> fetchActiveUsers();
}
