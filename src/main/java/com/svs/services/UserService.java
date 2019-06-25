package com.svs.services;

import com.svs.domain.User;
import com.svs.exceptions.ProjectException;
import com.svs.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveOrUpdate(User user) {
        try {
            user.setFullName(user.getFullName().toUpperCase());
            return userRepository.save(user);
        } catch (Exception e) {
            throw new ProjectException("User name '" + user.getFullName().toUpperCase() + "'already exists");
        }
    }

    public User findByFullName(String fullName) {
        User user = userRepository.findByFullName(fullName.toUpperCase());
        if (user == null) {
            throw new ProjectException("User name '" + fullName + "'does not exist");
        }
        return user;
    }

}
