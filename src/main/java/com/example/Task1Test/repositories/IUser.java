package com.example.Task1Test.repositories;

import com.example.Task1Test.model.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Stack;


public interface IUser extends CrudRepository<User,String> {

    User findById(int id);
    User findByUsername(String username);
    User findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.firstName = ?1")
    List<User> findByFirstName(String firstName);

    @Query("SELECT u FROM User u WHERE u.lastName = ?1")
    List<User> findByLastName(String firstName);


    List<User> findAll();

    void deleteById(int id);
}
