package com.example.appvaccine.dao;

import com.example.appvaccine.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolesRepository extends JpaRepository<Role,Integer> {

    // truy vấn theo jpa: java persitance API
//    @Query("SELECT r FROM Role r WHERE r.roleName = :name")
//    Optional<Role> findRoleByRoleName(@Param("name") String name);
    // truy vấn =
    @Query(value = "select * from tbl_roles r where r.roleName = ?1",nativeQuery = true)
    Optional<Role> findRoleByRoleName(String roleName);
}
