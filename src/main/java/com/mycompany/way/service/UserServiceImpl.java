/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.way.service;

import com.mycompany.way.dao.UserDAO;
import com.mycompany.way.entities.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class UserServiceImpl implements HelperService<User>{
    
    @Autowired
	private UserDAO userDAO;

    @Transactional
    public List<User> getAll() {
        return userDAO.getUsers();
    }

    @Transactional
    public void save(User theUser) {
        userDAO.saveUsers(theUser);
    }

    @Transactional
    public User get(int theId) {
        return userDAO.getUser(theId);
    }

    @Transactional
    public void delete(int theId) {
        userDAO.deleteUser(theId);
    }
    
    
    
}
