package com.example.demo.security.service;



import com.example.demo.entities.User;
import com.example.demo.service.IGeneralService;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface IUserService extends IGeneralService<User>, UserDetailsService {
    Optional<User> findByUsername(String username);
}
