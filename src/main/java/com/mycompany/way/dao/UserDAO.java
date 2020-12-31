/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.way.dao;

import com.mycompany.way.entities.User;
import java.util.List;

/**
 *
 * @author educacion
 */
public interface UserDAO {
    
     public List<User> getUsers();

     public void saveUsers(User theUser);

     public User getUser(int theId);
     
     public void deleteUser(int theId);
    
}
