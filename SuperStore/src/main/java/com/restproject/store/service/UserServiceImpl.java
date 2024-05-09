package com.restproject.store.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.restproject.store.entity.Users;
import com.restproject.store.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Users registerUser(Users user) {
       return userRepository.save(user);
    }

    @Override
    public List<Users> listAll() {
        return userRepository.findAll();
    }

    @Override
    public Users update(Users user) {
        return userRepository.save(user);
    }

    @Override
    public Users findById(int id) {
        Optional<Users> result = userRepository.findById(id);
        Users foundUser = null;
        if(result.isPresent()){
            foundUser = result.get();
        }
        return foundUser;
    }

    @Override
    public void deleteUser(int id) {
        Optional<Users> result = userRepository.findById(id);
        if(result.isPresent()){
            userRepository.deleteById(id);
            System.out.println("User Removed");
            return;
        }
        System.out.println("No user Exists with this Id");
    }
    
    
}
