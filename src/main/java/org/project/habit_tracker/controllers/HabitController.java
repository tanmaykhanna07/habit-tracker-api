package org.project.habit_tracker.controllers;

import org.project.habit_tracker.dtos.HabitResponseDTO;
import org.project.habit_tracker.services.HabitServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class HabitController {

    @Autowired
    private HabitServices habitServices;

    public HabitController(HabitServices habitServices){
        this.habitServices = habitServices;
    }

    public HabitResponseDTO addHabit(){
        return habitServices.addHabit();
    }

}
