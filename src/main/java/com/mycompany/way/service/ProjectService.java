package com.mycompany.way.service;

import com.mycompany.way.entities.Project;
import com.mycompany.way.entities.Ticket;
import com.mycompany.way.entities.User;
import java.util.List;
import java.util.Map;


public interface ProjectService extends HelperService<Project>{
    
      
    public List<User> getUsers(int theId);
     
    public List<Ticket> getTickets(int theId);
    
    public void saveAssociation(Map<String,String> theIds);
    
}
