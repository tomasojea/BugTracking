package com.mycompany.way.controller;


import com.mycompany.way.entities.Bug;
import com.mycompany.way.entities.Project;
import com.mycompany.way.entities.Ticket;
import com.mycompany.way.entities.User;
import com.mycompany.way.service.HelperService;
import java.util.List;
import java.util.Map;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ticket")
public class TicketController  {
    @Autowired
    private HelperService<Ticket> ticketservice;
    
//   @Autowired
//    private SessionFactory sessionFactory;
    
    
    @GetMapping("/list")
	public String listTickets(Model theModel) {
            
                List<Ticket> theTickets = ticketservice.getAll();
             
		theModel.addAttribute("tickets", theTickets);
		
		return "ticket_list";
	}
        
    @GetMapping("/delete")    
        public String deleteTicket(@RequestParam("customerId") int theId){
                
                ticketservice.delete(theId);
            
                return "home";
        }
        
     
        
        @Transactional
        @GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Project theProject = new Project();
		
		theModel.addAttribute("Project", theProject);
		
		return "project-form";
	}
        
	
        
        @Transactional
        @GetMapping("/showFormForAddUser")
	public String showFormForAddUser(Model theModel) {
		
		// create model attribute to bind form data
		User theUser = new User();
		
		theModel.addAttribute("User", theUser);
		
		return "user-form";
	}
        
	
        @GetMapping("/assignment")
	public String showFormAssignment(Model theModel) {
		
		// create model attribute to bind form data
		//Bug theBug = new Bug();
                SessionFactory sessionFactory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Ticket.class)
                                    .addAnnotatedClass(Project.class)
                                    .addAnnotatedClass(Bug.class)
                                    .addAnnotatedClass(User.class)
                                    .buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
                session.beginTransaction();
                //////////////////////////////////////////////////////////////
                Ticket theWrap = new Ticket();
                Query<Project> theQuery = session.createQuery("from Project",Project.class);
                List<Project> theProjects = theQuery.getResultList();
                Query<User> theQuery2 = session.createQuery("from User",User.class);
                List<User> theUsers = theQuery2.getResultList();
	        theModel.addAttribute("projects", theProjects);
                session.getTransaction().commit();
                System.out.println(theUsers);
		theModel.addAttribute("Tickets", theWrap);
                theModel.addAttribute("users", theUsers);
                //////////////////////////////////////////////////////////////
		
		return "project-assign";
	}  
        
        @PostMapping("/saveTicket")
	public String saveTicket(@RequestParam Map<String,String> theIds){
                      System.out.println(theIds.keySet());  
                      System.out.println(theIds.values()); 
                      //////////////////////////////////////////////////////////////
                      int projectId = Integer.parseInt(theIds.get("project"));
                      int userId = Integer.parseInt(theIds.get("user"));
                      //////////////////////////////////////////////////////////////
                      
                      SessionFactory sessionFactory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Ticket.class)
                                    .addAnnotatedClass(Project.class)
                                    .addAnnotatedClass(Bug.class)
                                    .addAnnotatedClass(User.class)
                                    .buildSessionFactory();
                      Session session = sessionFactory.getCurrentSession();
                      session.beginTransaction();
                      
                     ////////////////////////////////////////////////////////////// 
                      Project tempProject = session.get(Project.class, projectId);
                      User tempUser = session.get(User.class, userId);
                      tempUser.addProjects(tempProject);
		      //////////////////////////////////////////////////////////////
                      
		      session.getTransaction().commit();
		
		return "redirect:/bug/list";
	}   
        
//         @PostMapping("/assignment")
//	public String saveBug(@RequestParam Map<String,String> theIds){
//                      int projectId = Integer.parseInt(theIds.get("project"));
//                      int userId = Integer.parseInt(theIds.get("user"));
//                      SessionFactory sessionFactory = new Configuration()
//                                    .configure("hibernate.cfg.xml")
//                                    .addAnnotatedClass(Ticket.class)
//                                    .addAnnotatedClass(Project.class)
//                                    .addAnnotatedClass(Bug.class)
//                                    .addAnnotatedClass(User.class)
//                                    .buildSessionFactory();
//		Session session = sessionFactory.getCurrentSession();
//                session.beginTransaction();
//                Project tempProject = session.get(Project.class, projectId);
//                User tempUser = session.get(User.class,2);
//		      //System.out.println(bugId);
//                      System.out.println(userId);
//                      return "redirect:/ticket/list2";
//                      
//        }
//    @GetMapping("/showFormForAddbug")
//	public String showFormForAdd(Model theModel) {
//		
//		// create model attribute to bind form data
//		//Bug theBug = new Bug();
//                
//                Wrapper theWrap = new Wrapper();
//                List<Users> theUsers = ubservice.getUsers();
//                List<Bug> theBugs = ubservice.getBugs();
//                
//	        theModel.addAttribute("users", theUsers);
//                System.out.println(theUsers);
//		theModel.addAttribute("wrapper", theWrap);
//                theModel.addAttribute("bug", theBugs);
//		
//		return "bug-form";
//	}  
//        
//    @PostMapping("/saveBug")
//	public String saveBug(@RequestParam Map<String,String> theIds){
//                      int userId = Integer.parseInt(theIds.get("users"));
//                      int bugId = Integer.parseInt(theIds.get("bug"));
//                      Bug theBug = ubservice.getBug(bugId);
//                      System.out.println(bugId);
//                      ubservice.saveBugs(theBug, userId);
//		      System.out.println(ubservice.getUsers(userId).getName());
//		      
		
//		return "redirect:/bug/list";
//	}   
//        
//     @GetMapping("/test")
//	public String savetest(Model theModel) {
//		
//		// save the bug using our service
//                List<Users> theUsers = ubservice.getUsers();
//		theModel.addAttribute("users", theUsers);
//                System.out.println("********" + theUsers + "************" );
//                	               	
//		return "test";
//	}      
//    
}
