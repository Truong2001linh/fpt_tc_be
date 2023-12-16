package com.example.appvaccine.dao;

import com.example.appvaccine.entity.RelationShip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RelationshipRepository extends JpaRepository<RelationShip,Integer> {
    RelationShip save(RelationShip relationShip);
    List<RelationShip> findAll();
}
