package com.mycompany.way.dao;

import com.mycompany.way.entities.Project;
import com.mycompany.way.entities.Ticket;
import com.mycompany.way.entities.User;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectDAOImpl implements ProjectDAO{
    
    @Autowired
    private SessionFactory sessionFactory;

    public List<Project> getProjects() {
       
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Project> theQuery = currentSession.createQuery("from Project", Project.class);
        List<Project> projects = theQuery.getResultList();

        return projects;
    }

    public void saveProjects(Project theProjects) {
        
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(theProjects);
    }

    public Project getProject(int theId) {
       
        Session currentSession = sessionFactory.getCurrentSession();
        Project theProject = currentSession.get(Project.class, theId);
		
        return theProject;
    }

    public void deleteProject(int theId) {
        
        Session currentSession = sessionFactory.getCurrentSession();
        Query theQuery = currentSession.createQuery("delete from Project where id=:idProject");
        theQuery.setParameter("idProject", theId);
        theQuery.executeUpdate();
    }

    public List<User> getUsers(int theId) {
        
        Session currentSession = sessionFactory.getCurrentSession();
        Project tempProject = currentSession.get(Project.class,theId );
        List<User> userslist = tempProject.getUsers();
        
        return userslist;
    }

    public List<Ticket> getTickets(int theId) {
        
        Session currentSession = sessionFactory.getCurrentSession();
        Project tempProject = currentSession.get(Project.class,theId);
        List<Ticket> ticketlist = tempProject.getTickets();
                
        return ticketlist;        
    }

    @Override
    public void saveAssociation(Map<String,String> theIds) {
        
        Session currentSession = sessionFactory.getCurrentSession();
        int projectId = Integer.parseInt(theIds.get("project"));
        int ticketId = Integer.parseInt(theIds.get("ticket"));
        Project tempProject = currentSession.get(Project.class, projectId);
        Ticket tempTicket = currentSession.get(Ticket.class, ticketId);
        tempProject.add(tempTicket);
    }
    
}
