/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.way.entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Bug")
public class Bug {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idbug")
    private int idbug;
    @Column(name="name")
    private String name;
    @Column(name="status")
    private String status;
//    @JoinTable(name="Ticket", 
//    joinColumns={@JoinColumn(name="idBug")},
//    inverseJoinColumns={@JoinColumn(name="idbug")}
//    )
    @OneToMany( cascade = CascadeType.ALL, mappedBy = "bug")
    private List<Ticket> tickets;
    
    
 
    public int getIdbug() {
        return idbug;
    }

    public void setIdbug(int idbug) {
        this.idbug = idbug;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
            tempTicket.setBug(this);
        
    }

    

    

 
}
