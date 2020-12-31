package com.mycompany.way.entities;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


@Entity
//@Table(name="Project")
public class Project {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idProject")
    private int idproject;
    @Column(name="project_name")
    private String projectname;
    @ManyToMany(mappedBy = "projects")
    private List<User> users;
    
//    @JoinTable(name="Ticket", 
//    joinColumns={@JoinColumn(name="idProject")},
//    inverseJoinColumns={@JoinColumn(name="idproject")}
//    )
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
    //@LazyCollection(LazyCollectionOption.FALSE)
    private List<Ticket> tickets;
    

    public int getIdproject() {
        return idproject;
    }

    public void setIdproject(int idproject) {
        this.idproject = idproject;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

      public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
    
    public void add(Ticket tempTicket) {
        if (tickets == null){   
            tickets = new ArrayList();
            }   
            tickets.add(tempTicket);
            tempTicket.setProject(this);
        
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
