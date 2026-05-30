package org.project.habit_tracker.repository;

import org.project.habit_tracker.models.Habit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HabitRepository extends JpaRepository<Habit, Integer> {
}
