package com.mycompany.way.service;

import com.mycompany.way.dao.ProjectDAO;
import com.mycompany.way.dao.TicketDAO;
import com.mycompany.way.entities.Project;
import com.mycompany.way.entities.Ticket;
import com.mycompany.way.entities.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProjectServiceImpl implements ProjectService{
    
    @Autowired
	private ProjectDAO projectDAO;
    
    @Transactional
    public List<Project> getProjects() {
         return projectDAO.getProjects();
    }
    
    @Transactional
    public void saveProject(Project theProject) {
        projectDAO.saveProjects(theProject);
    }
    @Transactional
    public Project getProject(int theId) {
        return projectDAO.getProject(theId);
    }
    @Transactional
    public void deleteProject(int theId) {
        projectDAO.deleteProject(theId);
    }
    
    @Transactional
    public List<User> getUsers(int theId) {
       return projectDAO.getUsers(theId);
    }

    @Transactional
    public List<Ticket> getTickets(int theId) {
       return projectDAO.getTickets(theId);
    }
    
}
