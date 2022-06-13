package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import service.AccountService;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Set up a session
        HttpSession session = request.getSession();    
        
        //Checks if the user recently logged out
        if(request.getParameter("logout") != null) {
            request.setAttribute("logoutMessage", true);
            session.invalidate();
        }
        
        if(session.getAttribute("username") != null) {
            response.sendRedirect("home");
            return;
        }
        
        //Load the JSP
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Parameters
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        //Create a session
        HttpSession session = request.getSession();
        
        //Creates the user object
        User user = new AccountService().login(username, password);
        
        //Validation
        if(user == null) {
            request.setAttribute("username", username);
            
            //Makes the if statement go off to print the error message
            request.setAttribute("error", true);
            
            // Reloads the JSP
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }

        session.setAttribute("username", username);
        
        response.sendRedirect("home");
        return;
    }
}
