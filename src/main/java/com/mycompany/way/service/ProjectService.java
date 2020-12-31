package com.mycompany.way.service;

import com.mycompany.way.entities.Project;
import com.mycompany.way.entities.Ticket;
import com.mycompany.way.entities.User;
import java.util.List;


public interface ProjectService {
    
    public List<Project> getProjects();

    public void saveProject(Project theProject);

    public Project getProject(int theId);

    public void deleteProject(int theId);
    
    public List<User> getUsers(int theId);
     
    public List<Ticket> getTickets(int theId);
    
}
