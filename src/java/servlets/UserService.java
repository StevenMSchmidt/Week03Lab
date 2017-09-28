/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import javax.servlet.http.HttpServlet;

/**
 *
 * @author 685442
 */
public class UserService extends HttpServlet {
    
    private String[] userNameArray = {"adam", "betty"};
    private String password = "password";
    
    public boolean login (String usernameSent, String password){
        
        boolean yep = false;
        
         for(String user : userNameArray)
            if(user.equals(usernameSent))
                if(this.password.equals(password))
                yep = true;
            
        return yep;
    }
}
