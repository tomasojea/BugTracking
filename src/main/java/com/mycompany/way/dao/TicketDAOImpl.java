/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.way.dao;

import com.mycompany.way.entities.Ticket;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TicketDAOImpl implements TicketDAO{
    
    @Autowired
     private SessionFactory sessionFactory;

    public List<Ticket> getTickets() {
                // get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<Ticket> theQuery = 
				currentSession.createQuery("from Ticket",Ticket.class);
		
		// execute query and get result list
		List<Ticket> tickets = theQuery.getResultList();
				
		// return the results		
		return tickets;
            }

    public void saveTickets(Ticket theTickets) {
        
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theTickets);
    }

    public Ticket getTicket(int theId) {
                Session currentSession = sessionFactory.getCurrentSession();
		
		Ticket theTicket = currentSession.get(Ticket.class, theId);
		
		return theTicket;
    }

    public void deleteTicket(int theId) {
        
                Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Ticket where id=:idticket");
		theQuery.setParameter("idticket", theId);
		
		theQuery.executeUpdate();
    }
    
}
