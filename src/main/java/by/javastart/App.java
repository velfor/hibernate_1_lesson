package by.javastart;
import by.javastart.models.Auto;
import by.javastart.models.User;
import by.javastart.services.UserService;

import java.sql.SQLException;


public class App 
{
    public static void main(String[] args) throws SQLException {

        UserService userService = new UserService();
        userService.clearDB();
        User user = new User("Masha",26);
        userService.saveUser(user);
        Auto ferrari = new Auto("Ferrari", "red");
        ferrari.setUser(user);
        user.addAuto(ferrari);
        Auto ford = new Auto("Ford", "black");
        ford.setUser(user);
        user.addAuto(ford);
        userService.updateUser(user);
        user = new User("Petya", 34);
        userService.saveUser(user);

        System.out.println(userService.findAllUsers());
        //System.out.println(userService.findAllUsers());
    }
}
