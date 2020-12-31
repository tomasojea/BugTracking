/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.way.controller;

import com.mycompany.way.entities.User;
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
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/list")
        public String listUsers(Model theModel){

            List <User> theUsers = userService.getUsers();

            theModel.addAttribute("users", theUsers);

            return "user_list";
        }
    
    @GetMapping("/delete")    
        public String deleteTicket(@RequestParam("userId") int theId){
                
                userService.deleteUser(theId);
            
                return "user_list";
        }
    
    @GetMapping("/userForm")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		User theUser = new User();
		
		theModel.addAttribute("user", theUser);
		
		return "user-form";
	}    
        
    @PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") User theUser) {
		
		// save the customer using our service
		userService.saveUser(theUser);
		
		return "redirect:/user/list";
	}
        
    @GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("userId") int theId,
									Model theModel) {
		
		// get the customer from our service
		User theUser = userService.getUser(theId);
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("user", theUser);
		
		// send over to our form		
		return "user-form";
	}
}
