package com.example.Task1Test.controller;

import com.example.Task1Test.model.EmailDetails;
import com.example.Task1Test.model.User;
import com.example.Task1Test.repositories.IUser;
import com.example.Task1Test.service.EmailServiceImpl;
import com.example.Task1Test.service.IEmailService;
import com.example.Task1Test.service.IUserService;
import com.example.Task1Test.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IUser repo;

    @GetMapping("/user")
    public List<User> getAllUsers()
    {
        return repo.findAll();
    }
    @GetMapping("/user/{id}")
    public User findById(
            @PathVariable(value = "id") int id)
    {
        return repo.findById(id);
    }

    @PostMapping("/user")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void deleteUser(
            @PathVariable(value = "id") int id)
    {
        repo.deleteById(id);
    }

}
