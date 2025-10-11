package com.example.KTB_4WEEK.repository.user;

import com.example.KTB_4WEEK.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;


public interface UserRepository {
    List<User> findAll();

    Optional<User> regist(User user);

    Optional<User> findById(long id);

    Optional<User> updateById(long id, User target);

    Optional<User> deleteById(long id);
}
