package com.devni.tlp.finalproject.userservice.service;

import com.devni.tlp.finalproject.userservice.model.User;
import com.devni.tlp.finalproject.userservice.model.UserDTO;
import com.devni.tlp.finalproject.userservice.repository.UserRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                new ArrayList<>());
    }


    @Override
    public User save(UserDTO user) throws Exception {
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        newUser.setEmail(user.getEmail());
        newUser.setName(user.getName());
        newUser.setMobile(user.getMobile());
        newUser.setDeleted(false);
        newUser.setActive(true);
        user.setCreatedAt(Instant.now());
        user.setUpdatedAt(Instant.now());
        return userRepository.save(newUser);
//        if (findUserByEmail(user.getEmail()) && findUserByNIC(user.getNIC())) {
        /*if (findUserByEmail(user.getEmail()) && findUserByUsername(user.getUsername())) {
            user.setDeleted(false);
            user.setCreatedAt(Instant.now());
            user.setUpdatedAt(Instant.now());
            System.out.println("User saved");
            return userRepository.save(user);
        } else {
            System.out.println("User exists");
            throw new Exception("User exists");
        }*/
    }

    //    private boolean findUserByNIC(String nic) throws UserExistException {
    private boolean findUserByUsername(String nic) throws Exception {
        try {
            List<User> users = userRepository.findAll()
                    .stream()
                    .filter(user -> user.getUsername().equals(nic))
                    .collect(Collectors.toList());
            if (users.size() == 0)
                return true;
            else
                return false;
        } catch (Exception e) {
//            throw new UserExistException("This NIC has used before, please enter the correct NIC", e);
            throw new Exception("This NIC has used before, please enter the correct NIC", e);
        }
    }

    private boolean findUserByEmail(String email) throws Exception {
        try {
            List<User> users = userRepository.findAll()
                    .stream()
                    .filter(user -> user.getEmail().equals(email))
                    .collect(Collectors.toList());
            if (users.size() == 0)
                return true;
            else
                return false;
        } catch (Exception e) {
//            throw new UserExistException("This email id has used before, Please enter a correct email id", e);
            throw new Exception("This email id has used before, Please enter a correct email id", e);
        }
    }

    @Override
    public List<User> fetchAllUsers() {
        return userRepository.findAll();
    }

    @SneakyThrows
    @Override
    public User fetchUserById(int id) throws Exception {
        try {
            Optional<User> optional = userRepository.findById(id);
            if (optional.isPresent()) {
                return optional.get();
            }
            return null;
        } catch (Exception e) {
//            throw new UserNotFoundException("User not found", e);
            throw new Exception("User not found", e);
        }
    }

    @Override
    public User deleteUser(int id) throws Exception {
        User user = fetchUserById(id);
        user.setDeleted(false);
        return userRepository.saveAndFlush(user);
    }

    @Override
    public List<User> fetchDeletedUsers() {
        return fetchAllUsers().stream()
                .filter(user -> user.isDeleted() == true)
                .collect(Collectors.toList());
    }

    @Override
    public List<User> fetchActiveUsers() {
        return fetchAllUsers().stream()
                .filter(user -> user.isDeleted() == false)
                .collect(Collectors.toList());
    }
}
