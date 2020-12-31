/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.way.dao;

import com.mycompany.way.entities.User;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO{
    
    @Autowired
	private SessionFactory sessionFactory;

    public List<User> getUsers() {
        
        Session currentSession = sessionFactory.getCurrentSession();
        Query<User> theQuery = currentSession.createQuery("from User",User.class);
        List<User> users = theQuery.getResultList();
        
        return users;
    }

    public void saveUsers(User theUser) {
        
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(theUser);
        
    }

    public User getUser(int theId) {
        
        Session currentSession = sessionFactory.getCurrentSession();
        User theUser = currentSession.get(User.class, theId);

        return theUser;
    }

    public void deleteUser(int theId) {

        Session currentSession = sessionFactory.getCurrentSession();
        Query theQuery = currentSession.createQuery("delete from User where id=:idUser");
        theQuery.setParameter("idUser", theId);
        theQuery.executeUpdate();

    }
    
}
