package com.devni.tlp.finalproject.userservice.service;

import com.devni.tlp.finalproject.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequestMapping("/service")
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
}
