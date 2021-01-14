package com.johnmorf.web.service;

import com.johnmorf.web.Dao.UserDao;
import com.johnmorf.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public User getUserById(Long id) {
        return userDao.getUser(id);
    }

    public void addUser(User user) {
        userDao.addUser(user);
    }

    public void updateUser(Long id, User updatedUser) {
        userDao.update(id, updatedUser);
    }

    public void deleteUser(Long id) {
        userDao.delete(id);
    }

    public User findByUserName(String username) {
        return userDao.findByUserName(username);
    }
}


