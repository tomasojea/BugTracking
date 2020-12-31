package com.mycompany.way.service;

import com.mycompany.way.entities.User;
import java.util.List;


public interface UserService {
    
    public List<User> getUsers();

    public void saveUser(User theUser);

    public User getUser(int theId);

    public void deleteUser(int theId);
    
}
