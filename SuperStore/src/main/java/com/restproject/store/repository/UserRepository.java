package com.restproject.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restproject.store.entity.Users;

public interface UserRepository extends JpaRepository<Users,Integer>{
}
