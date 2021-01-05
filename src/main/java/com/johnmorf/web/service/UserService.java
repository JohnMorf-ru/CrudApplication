package com.johnmorf.web.service;

import com.johnmorf.web.Dao.UserDao;
import com.johnmorf.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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

    public User getUserById(int id) {
        return userDao.getUser(id);
    }

    public void addUser(User user) {
        userDao.addUser(user);
    }

    public void updateUser(int id, User updatedUser) {
        userDao.update(id, updatedUser);
    }

    public void deleteUser(int id) {
        userDao.delete(id);
    }
}


