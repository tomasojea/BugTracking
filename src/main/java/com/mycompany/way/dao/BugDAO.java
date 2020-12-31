/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.way.dao;

import com.mycompany.way.entities.Bug;
import java.util.List;

/**
 *
 * @author educacion
 */
public interface BugDAO {
    
    public List<Bug> getBugs();
        
    public Bug getBug(int id);

    public void saveBugs(Bug theBug);
    
     public void deleteBug(int theId);
    
}
