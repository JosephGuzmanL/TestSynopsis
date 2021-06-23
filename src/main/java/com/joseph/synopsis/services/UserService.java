package com.joseph.synopsis.services;

import com.joseph.synopsis.Model.User;
import org.springframework.stereotype.Service;

import java.util.List;

//Interface for business methods
public interface UserService {
    List<User> listAllUsers();
    User getUser(Long id);
    User createUser(User user);
    User updateUser(User user);
    void deleteUser(Long id);
}
