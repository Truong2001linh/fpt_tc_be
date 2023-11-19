package com.example.appvaccine.controller;

import com.example.appvaccine.entity.Role;
import com.example.appvaccine.service.RolesService;
import com.example.appvaccine.service.RolesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RolesController {

    @Autowired
    private RolesService rolesService;

    public RolesController(RolesServiceImpl rolesServiceIpm1) {
        this.rolesService = rolesServiceIpm1;
    }

    @GetMapping("/list")
    public List<Role> listRole(){
        return rolesService.findAllRoles();
    }
}
