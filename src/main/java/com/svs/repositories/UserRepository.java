package com.svs.repositories;

import com.svs.domain.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepository extends JpaRepository <User, Long> {

    User findByFullName(String fullName);

    @Override
    List<User> findAll(Sort sort);
}
