package com.restproject.store.service;

import java.util.List;

import com.restproject.store.entity.Users;

public interface UserService {
    
    public Users registerUser(Users user);

    public List<Users> listAll();

    public Users update(Users user);

    public Users findById(int id);

    public void deleteUser(int id);
}
