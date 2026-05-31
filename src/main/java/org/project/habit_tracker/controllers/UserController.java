package org.project.habit_tracker.controllers;

import jakarta.validation.Valid;
import org.project.habit_tracker.dtos.UserRequestDTO;
import org.project.habit_tracker.dtos.UserResponseDTO;
import org.project.habit_tracker.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserServices userService;

    @PostMapping("/register")
    public UserResponseDTO register(@RequestBody @Valid UserRequestDTO requestDTO){
        return userService.register(requestDTO);
    }

    @PostMapping("/login")
    public String login(@RequestBody @Valid UserRequestDTO requestDTO){
        return userService.verify(requestDTO);
    }
}

