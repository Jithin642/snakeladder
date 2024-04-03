package service;

import models.User;
import repository.UserRepository;

public class UserService {
    UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void addUser(User user){
        userRepository.addUser(user);
    }

}
