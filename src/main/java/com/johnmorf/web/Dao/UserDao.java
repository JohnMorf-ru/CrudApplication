package com.johnmorf.web.Dao;

import com.johnmorf.web.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDao {

    private List<User> users;

    {
        users = new ArrayList<>();
        users.add(new User(1, "John", " Morf", 24));
        users.add(new User(2, "Elice", " Smith", 24));
        users.add(new User(3, "Norman", " Kane", 24));
    }

    public List<User> getAllUsers() {
        return users;
    }

    public User getUser(int id) {
        return users.stream().filter(user -> user.getId()==id).findAny().orElse(null);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void update(int id, User updatedUser) {
        User userToUpdate = this.getUser(id);
        userToUpdate.setAge(updatedUser.getAge());
        userToUpdate.setLastName(updatedUser.getLastName());
        userToUpdate.setName(updatedUser.getName());

    }

    public void delete(int id) {
        users.removeIf(user -> user.getId()==id);
    }
}
