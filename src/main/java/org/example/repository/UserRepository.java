package org.example.repository;

import org.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    // CREATE
    public void save(User user) {
        mongoTemplate.save(user);
    }

    // READ ALL
    public List<User> findAll(Sort salary) {
        return mongoTemplate.findAll(User.class);
    }

    // READ BY ID
    public User findById(String id) {
        return mongoTemplate.findById(id, User.class);
    }

    // UPDATE
    public void update(User user) {
        mongoTemplate.save(user);
    }

    // DELETE
    public void delete(String id) {
        User user = findById(id);
        if (user != null) {
            mongoTemplate.remove(user);
        }
    }
}
