package com.svs.services;

import com.svs.domain.User;
import com.svs.exceptions.ProjectException;
import com.svs.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveOrUpdate(User user) {
        try {
            user.setFirstName(user.getFirstName().toUpperCase());
            return userRepository.save(user);
        } catch (Exception e) {
            throw new ProjectException("User name '" + user.getFirstName().toUpperCase() + "'already exists");
        }
    }

    public User findByFullName(String firstName) {
        User user = userRepository.findByFirstName(firstName.toUpperCase());
        if (user == null) {
            throw new ProjectException("User name '" + firstName + "'does not exist");
        }
        return user;
    }

    public List<User> findallUsers() {
        return userRepository.findAll();
    }

    public void deleteUserByFirstName(String firstName) {

        User user = userRepository.findByFirstName(firstName.toUpperCase());

        if (user == null) {
            throw new ProjectException("Can not delete user with name '" + firstName + "'. It does not exist");
        }

        userRepository.delete(user);
    }
}
