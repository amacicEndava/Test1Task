package com.example.Task1Test.service;

import com.example.Task1Test.model.EmailDetails;
import com.example.Task1Test.model.User;
import com.example.Task1Test.repositories.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private EmailServiceImpl emailService;

    @Autowired
    private IUser repo;


    EmailDetails details = new EmailDetails();

    @Override
    public User addUser(User user) {


        details.setRecipient("andrej.macic121@gmail.com");
        details.setSubject("Username: " + user.getUsername() + " Created" );
        details.setMsgBody("A new user with the username of: " + user.getUsername() + "was created");

        emailService.sendSimpleMail(details);
        return repo.save(user);
    }

    @Override
    public User editUser(User user) {
        return repo.save(user);
    }

    @Override
    public String deleteUser(String username) {
        User deletedUser = repo.findByUsername(username);
        repo.delete(deletedUser);
        return username + "Deleted";
    }
}
