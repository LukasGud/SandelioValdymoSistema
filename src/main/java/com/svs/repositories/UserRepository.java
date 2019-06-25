package com.svs.repositories;

import com.svs.domain.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {

    User findByFirstName(String firstName);

    @Override
    List<User> findAll(Sort sort);
}
