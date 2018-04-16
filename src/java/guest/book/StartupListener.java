
package guest.book;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class StartupListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        UserManager users = new UserManager();
        
        User johndoe = users.register("johndoe", "P@ssw0rd", "P@ssw0rd");
        User phillip = users.register("phillip", "P@ssw0rd","P@ssw0rd");
        User janedoe = users.register("janedoe", "P@ssw0rd","P@ssw0rd");
        User tiffany = users.register("tiffany", "P@ssw0rd","P@ssw0rd");
        
        sce.getServletContext().setAttribute("users", users);
        PostManager posts = new PostManager();
        
        posts.post(johndoe,"What's up!", "What is this all about anyway???");
        posts.post(janedoe,"What's up!", "What is this all about anyway???");
        posts.post(phillip, "Bad to the bone", "Hey Fellas, We are ready to go!");
        posts.post(tiffany, "Bad to the bone", "Hey Fellas, We are ready to go!");
        
        sce.getServletContext().setAttribute("posts", posts);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        
    }
}
