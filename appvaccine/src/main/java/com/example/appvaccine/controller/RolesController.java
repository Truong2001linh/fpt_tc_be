package com.example.appvaccine.controller;

import com.example.appvaccine.entity.Role;
import com.example.appvaccine.service.RolesService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
public class RolesController {

    private RolesService rolesService;

    @Autowired
    public RolesController(RolesService rolesService) {
        this.rolesService = rolesService;
    }

    @GetMapping("/list")
    public List<Role> listRole(){
        return rolesService.findAllRoles();
    }
}
