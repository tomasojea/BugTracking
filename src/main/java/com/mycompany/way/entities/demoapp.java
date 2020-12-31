/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.way.entities;

import com.mycompany.way.entities.Ticket;
import com.mycompany.way.entities.Project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class demoapp {

    
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Ticket.class)
                                    .addAnnotatedClass(Project.class)
                                    .addAnnotatedClass(Bug.class)
                                    .addAnnotatedClass(User.class)
                                    .buildSessionFactory();
        
        // create session
        Session session = factory.getCurrentSession();
        try{
            
            // start a transaction
            session.beginTransaction();
            // get the instructor from db
             //Project tempProject = new Project();
             Bug tempBug = session.get(Bug.class, 1);
             //Ticket tempTicket = session.get(Ticket.class, tempProject.getTickets().get(0).getIdticket());
             //Ticket tempTicket2 = session.get(Ticket.class, tempProject.getTickets().get(0).getIdticket());
             Ticket tempTicket = session.get(Ticket.class,1);
             Ticket tempTicket2 = session.get(Ticket.class,2);
             
             //Ticket tempTicket = new Ticket();
             //Query<Ticket> theQuery = session.createQuery("from Ticket",Ticket.class);
             //System.out.println(theQuery.setFirstResult(0).getResultList().get(0).getProject().getProjectname());
             //System.out.println(theQuery.setFirstResult(1).getResultList().get(1).getProject().getProjectname());
             tempBug.add(tempTicket);
             tempBug.add(tempTicket2);
             //tempTicket.setProject(tempProject);
             
             
             
//            int theId = 1;
//            Ticket tempTicket = session.get(Ticket.class, theId);
//            System.out.println("######################################");
//            System.out.println("Instructor: " + tempTicket);
//            System.out.println("######################################");
//            
//            // get courses from the instructor 
//            System.out.println("######################################");
//            System.out.println("Courses: " 
//                    + tempTicket.getProject().getProjectname());
//            System.out.println("######################################");
//            // commit transaction 
            session.save(tempTicket);
            session.save(tempTicket2);
            //session.save(tempProject);
            //session.save(tempTicket);
            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally{
            // add clean up code
            session.close();
            factory.close();
        }
        
        
        
    }
    
}
