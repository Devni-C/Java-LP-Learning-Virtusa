package com.devni.tlp.finalproject.userservice.controller;

import com.devni.tlp.finalproject.userservice.model.User;
import com.devni.tlp.finalproject.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/getallusers")
    public List<User> getAllUsers() {
        return userService.fetchAllUsers();
    }

    @RequestMapping("/getuserbyid/{uid}")
    public User getUserById(@PathVariable int uid) throws Exception {
        return userService.fetchUserById(uid);
    }

    @RequestMapping(value = "/getdeletedusers", method = RequestMethod.GET)
    public List<User> fetchDeletedUsers() {
        return userService.fetchDeletedUsers();
    }

    @RequestMapping(value = "/getActiveusers", method = RequestMethod.GET)
    public List<User> fetchActiveUsers() {
        return userService.fetchActiveUsers();
    }
}
