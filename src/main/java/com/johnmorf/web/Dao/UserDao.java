package com.johnmorf.web.Dao;

import com.johnmorf.web.model.User;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<User> getAllUsers() {
        return entityManager.createQuery("FROM User").getResultList();
    }

    public User getUser(Long id) {
        return entityManager.find(User.class, id);
    }

    public void addUser(User user) {
        entityManager.merge(user);
    }

    public void update(Long id, User updatedUser) {
        entityManager.merge(updatedUser);
    }

    public void delete(Long id) {
        entityManager.remove(getUser(id));
    }

    public User findByUserName(String username) {
        TypedQuery<User> query = entityManager.createQuery(
                "SELECT u FROM User u WHERE u.email = :username", User.class);
        return query.setParameter("username", username).getSingleResult();
    }
}
