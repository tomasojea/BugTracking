
package com.mycompany.way.service;

import com.mycompany.way.dao.TicketDAO;
import com.mycompany.way.entities.Ticket;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class TicketServiceImpl implements HelperService<Ticket>{
    
    @Autowired
	private TicketDAO ticketDAO;
    
    @Transactional
    public List<Ticket> getAll() {
        return ticketDAO.getTickets();
    }
    
    @Transactional
    public void save(Ticket theTicket) {
        ticketDAO.saveTickets(theTicket);
    }
    
    @Transactional
    public Ticket get(int theId) {
        return ticketDAO.getTicket(theId);
    }
    
    @Transactional
    public void delete(int theId) {
        ticketDAO.deleteTicket(theId);
    }
    
}
