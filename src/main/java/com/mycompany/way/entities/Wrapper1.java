
package com.mycompany.way.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Wrapper1 {
    
    private Project projects;
    
    private Ticket tickets;
    
    @Bean
    public Project getProjects() {
        return projects;
    }
   
    public void setProjects(Project projects) {
        this.projects = projects;
    }
    @Bean
    public Ticket getTickets() {
        return tickets;
    }
    
    public void setUsers(Ticket tickets) {
        this.tickets = tickets;
    }
    
}
