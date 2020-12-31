package com.mycompany.way.dao;

import com.mycompany.way.entities.Project;
import com.mycompany.way.entities.Ticket;
import com.mycompany.way.entities.User;
import java.util.List;


public interface ProjectDAO {
    
     public List<Project> getProjects();

     public void saveProjects(Project theProjects);

     public Project getProject(int theId);

     public void deleteProject(int theId);
     
     public List<User> getUsers(int theId);
     
     public List<Ticket> getTickets(int theId);
     
  
}
