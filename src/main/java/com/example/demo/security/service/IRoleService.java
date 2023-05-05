package com.example.demo.security.service;



import com.example.demo.entities.Role;
import com.example.demo.service.IGeneralService;

public interface IRoleService extends IGeneralService<Role> {
    Role findByName(String name);
}
