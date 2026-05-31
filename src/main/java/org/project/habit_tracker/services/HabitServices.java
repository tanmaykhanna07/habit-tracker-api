package org.project.habit_tracker.services;

import org.project.habit_tracker.dtos.HabitRequestDTO;
import org.project.habit_tracker.dtos.HabitResponseDTO;
import org.project.habit_tracker.exceptions.ResourceNotFoundException;
import org.project.habit_tracker.models.Habit;
import org.project.habit_tracker.repository.HabitRepository;
import org.project.habit_tracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HabitServices {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private HabitRepository habitRepository;

    public HabitResponseDTO addHabit(HabitRequestDTO habitRequestDTO) {
        Habit habit = new Habit();
        habit.setName(habitRequestDTO.getName());
        habit.setDescription(habitRequestDTO.getDesc());
        habit.setDateCreated(LocalDate.now());
        Habit savedHabit = habitRepository.save(habit);
        return convertToDTO(savedHabit);
    }

    private HabitResponseDTO convertToDTO(Habit newHabit){
        return new HabitResponseDTO(
                newHabit.getHabitId(),
                newHabit.getName(),
                newHabit.getDescription(),
                newHabit.getDateCreated()
        );
    }

    public HabitResponseDTO getHabitById( Integer id) {
        Habit targetHabit = habitRepository.getHabitByHabitId(id);
        return convertToDTO(targetHabit);
    }

    public List<HabitResponseDTO> getAllHabits() {
        List<Habit> rawHabits = habitRepository.findAll();

        return rawHabits.stream()
                .map(habit -> convertToDTO(habit))
                .collect(Collectors.toList());
    }

    public void deleteHabitById(Integer id) {
        habitRepository.deleteById(id);
    }

    public void deleteHabits() {
        habitRepository.deleteAll();
    }

    public HabitResponseDTO updateHabitById(Integer id, HabitRequestDTO incomingRequestDTO) {
        Habit oldHabit = habitRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Habit not found")
        );
        oldHabit.setName(incomingRequestDTO.getName());
        oldHabit.setDescription(incomingRequestDTO.getDesc());
        Habit savedHabit = habitRepository.save(oldHabit);
        return convertToDTO(savedHabit);
    }
}
