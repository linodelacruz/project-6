
package guest.book;

import java.io.Serializable;
import java.time.LocalDate;

public class User implements Serializable {
    private String username;
    private String password;
    private LocalDate joined;

    public User() {
    }

    public User(String username, String password, LocalDate joined) {
        this.username = username;
        this.password = PasswordHash.hashPassword(password);
        this.joined  = joined;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getJoined() {
        return joined;
    }

    public void setJoined(LocalDate joined) {
        this.joined = joined;
    }
    
    public boolean checkPassword(String passwordToTest) {
        return this.password.equals(PasswordHash.hashPassword(passwordToTest));
    }  

    @Override
    public String toString() {
        return "User{" + "username=" + username + ", password=" + password +
                ", joined=" + joined + '}';
    }

}