/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.way.service;

import com.mycompany.way.entities.Ticket;
import java.util.List;

/**
 *
 * @author educacion
 */
public interface TicketService {
    
    public List<Ticket> getTickets();

    public void saveTicket(Ticket theTicket);

    public Ticket getTicket(int theId);

    public void deleteTicket(int theId);
}
