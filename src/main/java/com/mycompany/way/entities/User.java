
package com.mycompany.way.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class User {

   
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idUser")
    private int idUser;
    @Column(name="name")
    private String name;
    @OneToMany( cascade = CascadeType.ALL, mappedBy = "user")
    private List<Ticket> tickets;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "Ticket", 
        joinColumns = { @JoinColumn(name = "iduser") }, 
        inverseJoinColumns = { @JoinColumn(name = "idproject") }
    )
    List<Project> projects;
  

    
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public void add(Ticket tempTicket) {
        if (tickets == null){ // check if the object is null for whatever reason  
            tickets = new ArrayList(); // Instanciate the object
            }   
            tickets.add(tempTicket); // add tickets to the user list.
            tempTicket.setUser(this); // associate the ticket object with the user.
        
    }
    
    public void addProjects(Project tempProject){
    
        if (projects == null){
            projects = new ArrayList();
        }
        projects.add(tempProject);
        
        
    }
   
   
    
}
    
