package com.example.appvaccine.dao;

import com.example.appvaccine.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query(value = "select * from tbl_users r where r.phoneNumber = ?1",nativeQuery = true)
    Optional<User> findByPhoneNumber(String phoneNumber);

//    Optional<User> findUsersByRole(Role role);

    User findByUserId(Integer id);
    @Query(value = "SELECT * FROM tbl_users u WHERE u.phoneNumber = ?1", nativeQuery = true)
    User findUserByPhoneNumber(String phoneNumber);

    List<User> findAll();
//    User updateUserByPhoneNumber(User phoneNumber);
}
