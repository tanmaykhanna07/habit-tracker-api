package org.project.habit_tracker.repository;

import org.project.habit_tracker.models.Habit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HabitRepository extends JpaRepository<Habit, Integer> {
    public Habit getHabitByHabitId(Integer id);
    public List<Habit> getHabitByUserUsername(String username);

}
