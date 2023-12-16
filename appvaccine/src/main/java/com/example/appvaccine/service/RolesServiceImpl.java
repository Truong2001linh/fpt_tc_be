package com.example.appvaccine.service;

import com.example.appvaccine.dao.RolesRepository;
import com.example.appvaccine.entity.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolesServiceImpl implements RolesService {
    private final RolesRepository rolesRepository;

    @Autowired
    public RolesServiceImpl(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    @Override
    public List<Role> findAllRoles() {
        return rolesRepository.findAll();
    }

    @Override
    public Role findRoleById(int id) {
        return rolesRepository.findByRoleId(id);
    }

}
