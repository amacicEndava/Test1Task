package com.example.Task1Test.service;

import com.example.Task1Test.model.User;

public interface IUserService {


    public User addUser(User user);

    public User editUser(User user);

    public String deleteUser(String user);


}
