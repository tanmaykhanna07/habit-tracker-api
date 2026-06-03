package org.project.habit_tracker.services;

import org.project.habit_tracker.dtos.LogResponseDTO;
import org.project.habit_tracker.enums.Status;
import org.project.habit_tracker.exceptions.ResourceNotFoundException;
import org.project.habit_tracker.models.DailyLog;
import org.project.habit_tracker.models.Habit;
import org.project.habit_tracker.repository.HabitRepository;
import org.project.habit_tracker.repository.LogRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LogServices {
    private final HabitRepository habitRepository;
    private final LogRepository logRepository;

    public LogServices(HabitRepository habitRepository, LogRepository logRepository) {
        this.habitRepository = habitRepository;
        this.logRepository = logRepository;
    }

    public LogResponseDTO tickMarkDate(Integer id) {
        Habit habit = habitRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Habit not found")
        );
        DailyLog log = logRepository.getDailyLogByHabit(habit);
        if(logRepository.getDailyLogByHabit(habit) == null){
            log = new DailyLog();
        }

        log.setStatus(Status.COMPLETED);
        log.setDate(LocalDate.now());
        DailyLog savedLog = logRepository.save(log);
        return convertToDTO(savedLog);
    }

    private LogResponseDTO convertToDTO(DailyLog log){
        return new LogResponseDTO(
                log.getLogId(),
                log.getDate(),
                log.getStatus()
        );
    }

    public List<LogResponseDTO> findAllCompletedDates() {
        List<DailyLog> logs = logRepository.getDailyLogByStatus(Status.COMPLETED);
        return logs.stream()
                .map(log -> convertToDTO(log))
                .collect(Collectors.toList());
    }
}
