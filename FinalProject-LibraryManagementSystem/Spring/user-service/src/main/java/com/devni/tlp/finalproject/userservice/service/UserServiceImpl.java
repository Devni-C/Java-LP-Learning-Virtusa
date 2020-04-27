package com.devni.tlp.finalproject.userservice.service;

import com.devni.tlp.finalproject.userservice.exception.UserNotFoundException;
import com.devni.tlp.finalproject.userservice.model.User;
import com.devni.tlp.finalproject.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service //UserDetailsServiceImpl
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        return CustomUserDetailsImpl.build(user);
    }

    /*@Override
    public User updateUser(User user) throws Exception, UserExistException {
        fetchUserById(user.getId());
        user.setName();
        return null;
    }*/

    @Override
    public List<User> fetchAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User fetchUserById(int id) throws UserNotFoundException {
        try {
            Optional<User> optional = userRepository.findById(id);
            if (optional.isPresent()) {
                return optional.get();
            }
            return null;
        } catch (Exception e) {
            throw new UserNotFoundException("User not found", e);
        }
    }

    @Override
    public User deleteUser(int id) throws UserNotFoundException {
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

