package com.devni.tlp.finalproject.userservice.service;

import com.devni.tlp.finalproject.userservice.model.User;
import com.devni.tlp.finalproject.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User saveUser(User user) throws Exception {
        if (findUserByEmail(user.getEmail()) && findUserByNIC(user.getNIC())) {
            System.out.println("User saved");
            return userRepository.save(user);
        } else {
            System.out.println("User exists");
            throw new Exception("User exists");
        }
    }

    private boolean findUserByNIC(String nic) {
        List<User> users = userRepository.findAll()
                .stream()
                .filter(user -> user.getNIC().equals(nic))
                .collect(Collectors.toList());
        if (users.size() == 0)
            return true;
        else
            return false;
    }

    private boolean findUserByEmail(String email) {
        List<User> users = userRepository.findAll()
                .stream()
                .filter(user -> user.getEmail().equals(email))
                .collect(Collectors.toList());
        if (users.size() == 0)
            return true;
        else
            return false;
    }

    @Override
    public List<User> fetchAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User fetchUserById(int id) {
        return userRepository.findById(id).get();
    }
}
