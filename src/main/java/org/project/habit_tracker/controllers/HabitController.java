package org.project.habit_tracker.controllers;

import jakarta.validation.Valid;
import org.project.habit_tracker.dtos.HabitRequestDTO;
import org.project.habit_tracker.dtos.HabitResponseDTO;
import org.project.habit_tracker.services.HabitServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class HabitController {

    @Autowired
    private HabitServices habitServices;

    public HabitController(HabitServices habitServices){
        this.habitServices = habitServices;
    }

    @PostMapping("/habit")
    public HabitResponseDTO addHabit(@Valid @RequestBody HabitRequestDTO requestDTO){
        return habitServices.addHabit(requestDTO);
    }

    @GetMapping("/habit/{id}")
    public HabitResponseDTO getHabitsById(@PathVariable Integer id){
        return habitServices.getHabitById(id);
    }

    @GetMapping("/habit/all")
    public List<HabitResponseDTO> getAllHabits(){
        return habitServices.getAllHabits();
    }

    @DeleteMapping("/delete/habit/{id}")
    public void deleteHabitById(@PathVariable Integer id){
        habitServices.deleteHabitById(id);
    }

    @DeleteMapping("/delete/habits")
    public void deleteAllHabits(){
        habitServices.deleteHabits();
    }

}
