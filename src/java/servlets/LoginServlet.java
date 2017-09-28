/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import problemDomain.User;

/**
 *
 * @author 685442
 */
public class LoginServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        
            }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("userN");
        String password = request.getParameter("passW");
        
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        
        if (username == null || password == null || username.isEmpty() || password.isEmpty() ){
            
            request.setAttribute("errorMessage", "Both values are required!");
            
            request.setAttribute("username", user.getUsername());
            request.setAttribute("password", user.getPassword());
            
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
            
        }
        
        UserService us = new UserService();
        boolean loginYep = us.login(username, password);
        
        if(!loginYep)
         {
          request.setAttribute("userN", username);
          request.setAttribute("passW", password);
          request.setAttribute("errorMessage", "Invalid username or password!");

          getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
         }
        request.setAttribute("userN", username);
        request.setAttribute("passW", password);    
        getServletContext().getRequestDispatcher("/WEB-INF/mainpage.jsp").forward(request, response);
        
    }

}
