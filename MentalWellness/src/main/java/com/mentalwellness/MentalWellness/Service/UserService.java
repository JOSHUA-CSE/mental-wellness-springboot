package com.mentalwellness.MentalWellness.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentalwellness.MentalWellness.model.User;
import com.mentalwellness.MentalWellness.Repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository user_repo;

    public List<User> getAllUsers() {
        return user_repo.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return user_repo.findById(id);
    }

    public User createUser(User user) {
        return user_repo.save(user);
    }

    public User updateUser(Long id, User userDetails) {
        User user = user_repo.findById(id).orElseThrow();
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        user.setContact_no(userDetails.getContact_no());
        user.setJoin_date(userDetails.getJoin_date());
        return user_repo.save(user);
    }

    public void deleteUser(Long id) {
        user_repo.deleteById(id);
    }
}