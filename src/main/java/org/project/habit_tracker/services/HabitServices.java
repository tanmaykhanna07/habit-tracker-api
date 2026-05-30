package org.project.habit_tracker.services;

import org.project.habit_tracker.dtos.HabitRequestDTO;
import org.project.habit_tracker.dtos.HabitResponseDTO;
import org.project.habit_tracker.models.Habit;
import org.project.habit_tracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HabitServices {
    @Autowired
    private UserRepository userRepository;
    public HabitResponseDTO addHabit(HabitRequestDTO habitRequestDTO) {
    }

    private HabitResponseDTO converToDTO(Habit newHabit){
        return new HabitResponseDTO(
                newHabit.getHabitId(),
                newHabit.getName(),
                newHabit.getDescription(),
                userRepository.



        )
    }
}
