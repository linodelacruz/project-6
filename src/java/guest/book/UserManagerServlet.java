
package guest.book;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/register")
public class UserManagerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request, response);
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null)
            request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
        
        else {
            UserManager users = (UserManager) getServletContext().getAttribute("users");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String password1 = request.getParameter("password1");
            User user = users.register(username, password, password1);
            if (user == null) {
                request.setAttribute("flash", "Unable to register, Verify your that your passwords match");
                request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
            } else {
                request.getSession().setAttribute("user", user);
                System.out.println("this is the user created" + user);
                response.sendRedirect("/guestbook/");
            }
        }
        
    }

   
        
    
    
 
}
