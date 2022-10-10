package project.projectspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import project.projectspring.domain.User;
import project.projectspring.service.UserService;

@Controller
public class UserController {
    
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/")
    public List<User> allUser() {
        return userService.findUsers();
    }
}
