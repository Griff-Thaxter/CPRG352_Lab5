package models;

import java.io.Serializable;

public class User implements Serializable {
  private String username, password;

    public User(String usernane, String password) {
        this.username = usernane;
        this.password = password;
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
    
}
