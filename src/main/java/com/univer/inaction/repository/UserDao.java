package com.univer.inaction.repository;

import com.univer.inaction.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

//@Repository
@Component
public class UserDao {

//    @Autowired
//    private UserRepository userRepository;
//
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    public User saveUser(User user) {
//        User savedUser = userRepository.save(user);
//        return savedUser;
//    }

    @Autowired
    private EntityManagerFactory managerFactory;

    public void save(User user) {
        EntityManager entityManager = managerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(user);
        transaction.commit();
        entityManager.close();
    }

    public User findOne(int id) {
        EntityManager entityManager = managerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        User user = entityManager.find(User.class, id);
        entityManager.close();
        return user;
    }
}
