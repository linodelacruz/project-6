
package guest.book;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private final List<User> users = new ArrayList<>();

    public UserManager() {}
    
    public User register(String username, String password, String password1) {
        if (! password.equals(password1))
            return null;
        if (! password1.matches("^[^<>'\"` ]{8,20}"))
            return null;
        /*
        if (! password1. matches("[A-Z]"))
            return null;
        if (! password1.matches("\\d"))
            return null;
        if (! password1.matches("[a-z]"))
            return null;
        if (! password1.matches("[\\-~!@#$%\\^&\\*\\(\\)\\+=\\|\\{\\}\\[\\]:;,\\?/]"))
            return null;
        */
        for (User u : users)
            if (u.getUsername().equals(username))
                return null;
        User newUser = new User(username, password, LocalDate.now());
        users.add(newUser);
        return newUser;
    }
    
    public User authenticate(String username, String password) {
        for (User u : users)
            if (u.getUsername().equals(username) &&
                    u.checkPassword(password))
                return u;
        return null;
    }
}