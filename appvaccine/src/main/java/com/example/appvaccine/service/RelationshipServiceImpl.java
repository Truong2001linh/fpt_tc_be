package com.example.appvaccine.service;

import com.example.appvaccine.dao.RelationshipRepository;
import com.example.appvaccine.entity.RelationShip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelationshipServiceImpl implements RelationshipService {
    private RelationshipRepository repository;

    @Override
    public RelationShip addRelationship(RelationShip relationShip) {
        return repository.save(relationShip);
    }

    @Override
    public List<RelationShip> getAllRe() {
        return repository.findAll();
    }
}
