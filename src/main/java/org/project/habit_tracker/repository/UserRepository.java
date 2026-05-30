package org.project.habit_tracker.repository;

import org.project.habit_tracker.models.Habit;
import org.project.habit_tracker.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<Users, Integer> {
}
