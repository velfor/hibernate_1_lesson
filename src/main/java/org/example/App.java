package org.example;

import org.example.models.User;
import org.example.models.Auto;
import org.example.services.UserService;
import java.sql.SQLException;

public class App 
{
    public static void main ( String[] args ) throws SQLException
    {
        UserService userService = new UserService();
        User user1 = new User("Masha", 26);
        userService.saveUser(user1);
        Auto ferrari = new Auto("Ferrari", "red");
        ferrari.setUser(user1);
        user1.addAuto(ferrari);
        Auto ford = new Auto("Ford", "black");
        ford.setUser(user1);
        user1.addAuto(ford);
        userService.updateUser(user1);
    }
}
