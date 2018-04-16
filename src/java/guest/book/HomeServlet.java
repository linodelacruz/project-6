
package guest.book;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PostManager manager = (PostManager) getServletContext().getAttribute("posts");
        List<Post> posts = manager.getAllPosts(0, 10);
        request.setAttribute("posts", posts);
        System.out.println("These are the default posts from the Home Sevlet"+ posts);
        request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
    }
    
}
