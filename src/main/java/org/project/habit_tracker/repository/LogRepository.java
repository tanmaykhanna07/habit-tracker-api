package org.project.habit_tracker.repository;

import org.project.habit_tracker.enums.Status;
import org.project.habit_tracker.models.DailyLog;
import org.project.habit_tracker.models.Habit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LogRepository extends JpaRepository<DailyLog,Integer> {
    public DailyLog getDailyLogByHabit(Habit habit);
    public List<DailyLog> getDailyLogByStatus(Status status);
}
