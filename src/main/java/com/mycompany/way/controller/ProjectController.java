package com.mycompany.way.controller;

import com.mycompany.way.entities.Project;
import com.mycompany.way.entities.Ticket;
import com.mycompany.way.entities.User;
import com.mycompany.way.entities.Wrapper1;
import com.mycompany.way.service.ProjectService;
import com.mycompany.way.service.TicketService;
import com.mycompany.way.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/project")
public class ProjectController {
    
    @Autowired
    private ProjectService projectService;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private TicketService ticketService;
   
    @RequestMapping("/welcome")
    public String welcome() {
        return "tables";
    }
    
    @GetMapping("/list")
        public String listProjects(Model theModel){

            List <Project> theProjects = projectService.getProjects();

            theModel.addAttribute("projects", theProjects);

            return "project-list";
        }
    
    @GetMapping("/delete")    
        public String deleteProject(@RequestParam("projectId") int theId){
                
                projectService.deleteProject(theId);
            
                return "redirect:/project/list";
        }
    
    @GetMapping("/projectForm")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Project theProject = new Project();
		
		theModel.addAttribute("project", theProject);
		
		return "project-form";
	}    
        
    @PostMapping("/saveProject")
	public String saveProject(@ModelAttribute("project") Project theProject) {
		
		// save the customer using our service
		projectService.saveProject(theProject);
		
		return "redirect:/project/list";
	}
        
    @GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("projectId") int theId,
									Model theModel) {
		
		// get the customer from our service
		Project theProject = projectService.getProject(theId);
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("project", theProject);
		
		// send over to our form		
		return "project-form";
	}
        
        @GetMapping("/ticketList")
	public String showTicketList(@RequestParam("projectId") int theId,
									Model theModel) {
		
		// get the customer from our service
		List <Ticket> theTickets = projectService.getTickets(theId);
		Project theProject = projectService.getProject(theId);
                theModel.addAttribute("projectName", theProject.getProjectname());
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("tickets", theTickets);
		
		// send over to our form		
		return "ticket_list";
	}
        
        @GetMapping("/userList")
	public String showProjectList(@RequestParam("projectId") int theId,
									Model theModel) {
		
		// get the customer from our service
		List <User> theUsers = projectService.getUsers(theId);
		//Project theProject = projectService.getProject(theId);
                //theModel.addAttribute("projectName", theProject.getProjectname());
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("users", theUsers);
		
		// send over to our form		
		return "user-list";
	}
        
        
        @GetMapping("/add")
	public String addTicket(Model theModel) {
		
		// get the customer from our service
                Wrapper1 theWrapper = new Wrapper1();
		List <Ticket> theTickets = ticketService.getTickets();
		List <Project> theProject = projectService.getProjects();
                System.out.println(theProject.get(1));
                theModel.addAttribute("projects", theProject);
		theModel.addAttribute("tickets", theTickets);
		theModel.addAttribute("wrapper", theWrapper);
		
		// send over to our form return "project-assign";		
		return "add-ticket";
	}
        
}
