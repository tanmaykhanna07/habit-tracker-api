package org.project.habit_tracker.repository;

import org.project.habit_tracker.models.DailyLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<DailyLog,Integer> {
}
