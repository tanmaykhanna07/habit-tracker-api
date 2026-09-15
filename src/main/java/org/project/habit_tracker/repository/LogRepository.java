package org.project.habit_tracker.repository;

import org.project.habit_tracker.enums.Status;
import org.project.habit_tracker.models.DailyLog;
import org.project.habit_tracker.models.Habit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface LogRepository extends JpaRepository<DailyLog,Integer> {
    DailyLog getDailyLogByHabitAndDate(Habit habit, LocalDate date);

    List<DailyLog> getDailyLogByStatusAndHabit(Status status, Habit habit);
}
