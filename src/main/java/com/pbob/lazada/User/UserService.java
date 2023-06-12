package com.pbob.lazada.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




/**
 * UserService
 */
@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll() {
        return this.userRepository.findAll();
    }

    public void simpan(User user) {
        this.userRepository.save(user);
    }

    public void hapus(Long id) {
        this.userRepository.deleteById(id);
    }
    public User getById(Long id) {
        User user = this.userRepository.findById(id).orElse(null);

        return user;
    }

    public void edit(Long id, User user) {
        User product_lama = this.userRepository.findById(id).orElse(null);

        product_lama.setUsername(user.getUsername());
        product_lama.setPassword(user.getPassword());
        product_lama.setEmail(user.getEmail());
        product_lama.setRole(user.getRole());
       
        this.userRepository.save(product_lama);
    }

}

