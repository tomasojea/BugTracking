package com.mycompany.way.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class Ticket {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idticket")
    private int idticket;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, 
                          CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="idproject")
    private Project idproject;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, 
                          CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="idbug")
    private Bug bug;

    public int getIdticket() {
        return idticket;
    }

    public void setIdticket(int idticket) {
        this.idticket = idticket;
    }
 
    public Bug getBug() {
        return bug;
    }

    public void setBug(Bug bug) {
        this.bug = bug;
    }

    public Project getIdproject() {
        return idproject;
    }

    public void setIdproject(Project idproject) {
        this.idproject = idproject;
    }
    
}
