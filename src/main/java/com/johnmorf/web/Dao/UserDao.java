package com.johnmorf.web.Dao;

import com.johnmorf.web.model.User;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<User> getAllUsers() {
        return entityManager.createQuery("from User").getResultList();
    }

    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }

    public void addUser(User user) {
        entityManager.merge(user);
    }

    public void update(int id, User updatedUser) {
        entityManager.merge(updatedUser);
    }

    public void delete(int id) {
        entityManager.remove(getUser(id));
    }
}
