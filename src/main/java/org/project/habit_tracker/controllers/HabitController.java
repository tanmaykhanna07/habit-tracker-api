package org.project.habit_tracker.controllers;

import jakarta.validation.Valid;
import org.project.habit_tracker.dtos.HabitRequestDTO;
import org.project.habit_tracker.dtos.HabitResponseDTO;
import org.project.habit_tracker.services.HabitServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
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
    public HabitResponseDTO addHabit(@Valid @RequestBody HabitRequestDTO requestDTO, Principal principal){
        return habitServices.addHabit(requestDTO, principal.getName());
    }

    @GetMapping("/habit/{id}")
    public HabitResponseDTO getHabitsById(@PathVariable Integer id){
        return habitServices.getHabitById(id);
    }

    @GetMapping("/habits")
    public List<HabitResponseDTO> getAllHabits(Principal principal){
        return habitServices.getAllHabits(principal.getName());
    }

    @DeleteMapping("/habit/{id}")
    public void deleteHabitById(@PathVariable Integer id){

        habitServices.deleteHabitById(id);
    }

    @DeleteMapping("/habits")
    public void deleteAllHabits(){
        habitServices.deleteHabits();
    }
    @PutMapping("/habit/{id}")
    public HabitResponseDTO updateHabitById(@PathVariable Integer id, @RequestBody HabitRequestDTO incomingRequestDTO){
        return habitServices.updateHabitById(id, incomingRequestDTO);
    }

}
