import models.User;
import repository.UserRepository;
import service.SplitwiseService;
import service.UserService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();

        User user1 = new User("u1", "u1");
        User user2 = new User("u2", "u2");
        User user3 = new User("u3", "u3");
        User user4 = new User("u4", "u4");

        UserService userService = new UserService(userRepository);
        userService.addUser(user1);
        userService.addUser(user2);
        userService.addUser(user3);
        userService.addUser(user4);

        SplitwiseService splitwiseService = new SplitwiseService(userRepository);

        splitwiseService.processActionType();

    }
}