package org.project.habit_tracker.controllers;

import org.project.habit_tracker.dtos.LogResponseDTO;
import org.project.habit_tracker.services.LogServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class LogsController {

    private final LogServices logServices;

    public LogsController(LogServices logServices) {
        this.logServices = logServices;
    }

    @PostMapping("/log/{id}")
    public LogResponseDTO tickMarkDate(@PathVariable Integer id){
        return logServices.tickMarkDate(id);
    }

    @GetMapping("log/completed")
    public List<LogResponseDTO> findAllCompletedDates(){
        return logServices.findAllCompletedDates();

    }
}
