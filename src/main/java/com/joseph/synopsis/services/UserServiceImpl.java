package com.joseph.synopsis.services;

import com.google.common.hash.Hashing;
import com.joseph.synopsis.Model.User;
import com.joseph.synopsis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.List;

//Implemented business methods
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> listAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User createUser(User user) {
        //crypt pass
        user.setPassword(Hashing.sha256()
                .hashString(user.getPassword(), StandardCharsets.UTF_8)
                .toString());
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        User userInDB = getUser(user.getId());
        if(userInDB==null) {
            return null;
        }
        else {
            userInDB.setName(user.getName());
            userInDB.setLastname(user.getLastname());
            userInDB.setPhone(user.getPhone());
            //crypt pass
            userInDB.setPassword(Hashing.sha256()
                    .hashString(user.getPassword(), StandardCharsets.UTF_8)
                    .toString());
            return userRepository.save(userInDB);
        }
    }

    @Override
    public void deleteUser(Long id) {
        User userInDB = getUser(id);
        if(userInDB!=null) {
            userRepository.deleteById(id);
        }
    }
}
