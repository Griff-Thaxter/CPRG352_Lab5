package service;

import models.User;


public class AccountService {
    public User login(String username, String password) {
        //Checks hardcoded users username and password  and if they match returns a user object with just the username
        if(username.equals("abe") && password.equals("password") || username.equals("barb") && password.equals("password")) {
            User user = new User(username, null);
            return user;
        }
        else {
            return null;
        }
    }
}
