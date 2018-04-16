
package guest.book;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/addcomments")
public class CommentManagerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/addcomments.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            request.getRequestDispatcher("/WEB-INF/views/home.jsp");
        }
        if (request.getMethod().equalsIgnoreCase("GET")) {
            request.getRequestDispatcher("/WEB-INF/views/addcomment").forward(request, response);
        } else {
            PostManager posts = (PostManager) getServletContext().getAttribute("posts");

            User author = (User) request.getSession().getAttribute("user");
            String content = request.getParameter("content");
            String title = request.getParameter("title");
            Post post = posts.post(author, title, content);
            if (post == null) {
                request.setAttribute("flash", "Content incorrect, please try again!");
                request.getRequestDispatcher("/WEB-INF/views/addcomments").forward(request, response);
            } else {
                request.setAttribute("posts", posts);

                response.sendRedirect("/guestbook/");
            }
        }

    }

   
}
