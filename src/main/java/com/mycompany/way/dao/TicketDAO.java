/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.way.dao;

import com.mycompany.way.entities.Project;
import com.mycompany.way.entities.Ticket;
import java.util.List;

/**
 *
 * @author educacion
 */
public interface TicketDAO {
    
    public List<Ticket> getTickets();

    public void saveTickets(Ticket theTickets);

    public Ticket getTicket(int theId);

    public void deleteTicket(int theId);
    
}
