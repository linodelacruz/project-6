
package guest.book;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
    }
    
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null)
            request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
        else {
            UserManager users = (UserManager) getServletContext().getAttribute("users");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            User user = users.authenticate(username, password);
            if (user == null) {
                request.setAttribute("flash", "Incorrect info entered, verify and try again!");
                request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
            } else {
                request.getSession().setAttribute("user", user);
                response.sendRedirect("/guestbook/");
                
            }
        }
    }

    
}
