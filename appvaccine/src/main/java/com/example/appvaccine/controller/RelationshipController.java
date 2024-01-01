package com.example.appvaccine.controller;

import com.example.appvaccine.entity.RelationShip;
import com.example.appvaccine.service.RelationshipService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/relationship")
@RequiredArgsConstructor
public class RelationshipController {
    @Autowired
    private RelationshipService relationshipService;

    @GetMapping("/getAll")
    public List<RelationShip> getAllRelationship(){
        return relationshipService.getAllRe();
    }
    @PostMapping("/addRe")
    public RelationShip addRelationship(@RequestBody RelationShip relationShip){
        return relationshipService.addRelationship(relationShip);
    }
}
