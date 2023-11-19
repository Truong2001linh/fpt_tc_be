package com.example.appvaccine.service;

import com.example.appvaccine.dao.RolesRepository;
import com.example.appvaccine.entity.Role;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolesServiceImpl implements RolesService {
    private RolesRepository rolesRepository;

    public RolesServiceImpl(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    @Override
    public List<Role> findAllRoles() {
        return rolesRepository.findAll();
    }

}
