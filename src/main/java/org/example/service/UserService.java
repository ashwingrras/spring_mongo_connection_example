package org.example.service;

import org.example.model.User;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public void createUser(User user) {
        repository.save(user);
    }

    public List<User> getAllUsers() {
        return repository.findAll(Sort.by(Sort.Direction.DESC,"salary"));
        //Sort.by(Sort.Direction.DESC,"salary")
    }

    public User getUser(String id) {
        return repository.findById(id);
    }

    public void updateUser(User user) {
        repository.update(user);
    }

    public void deleteUser(String id) {
        repository.delete(id);
    }
}
