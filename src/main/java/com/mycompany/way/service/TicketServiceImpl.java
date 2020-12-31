
package com.mycompany.way.service;

import com.mycompany.way.dao.TicketDAO;
import com.mycompany.way.entities.Ticket;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class TicketServiceImpl implements TicketService{
    
    @Autowired
	private TicketDAO ticketDAO;
    
    @Transactional
    public List<Ticket> getTickets() {
        return ticketDAO.getTickets();
    }
    
    @Transactional
    public void saveTicket(Ticket theTicket) {
        ticketDAO.saveTickets(theTicket);
    }
    
    @Transactional
    public Ticket getTicket(int theId) {
        return ticketDAO.getTicket(theId);
    }
    
    @Transactional
    public void deleteTicket(int theId) {
        ticketDAO.deleteTicket(theId);
    }
    
}
