package com.devni.tlp.finalproject.userservice.controller;

import com.devni.tlp.finalproject.userservice.model.User;
import com.devni.tlp.finalproject.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/test")
    public String test(){
        return "<h1>Hi Devni :D</h1>";
    }

    @RequestMapping("/getallusers")
    public List<User> getAllUsers() {
        return userService.fetchAllUsers();
    }

    @RequestMapping("/getuserbyid/{uid}")
    public User getUserById(@PathVariable int uid){
        return userService.fetchUserById(uid);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public User save(@RequestBody User user) {
        return userService.saveUser(user);
    }
}
