package com.devni.tlp.finalproject.userservice.controller;

import com.devni.tlp.finalproject.userservice.model.User;
import com.devni.tlp.finalproject.userservice.repository.UserRepository;
import com.devni.tlp.finalproject.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @RequestMapping("/getallusers")
//    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<User> getAllUsers() {
        return userService.fetchAllUsers();
    }

    @RequestMapping("/getuserbyid/{uid}")
    @PreAuthorize("hasRole('ADMIN')")
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

    /*@GetMapping("/allusers")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @DeleteMapping(path = {"/deleteuser/{id}"})
    public void deleteUser(@PathVariable Integer id) {
//        User user = userRepository.getOne(id);
        userRepository.deleteById(id);
//        return user;
    }*/

    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public String userAccess() {
        return "User Content.";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Board.";
    }

    @PostMapping("/testpost/{id}")
    public void testPost(@PathVariable int id) {
        System.out.println("you entered:" + id);
    }

}
