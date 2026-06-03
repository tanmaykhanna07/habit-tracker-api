package org.project.habit_tracker.models;

import jakarta.persistence.*;
import org.project.habit_tracker.enums.Status;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "logs")
public class DailyLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer logId;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "status")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "habit_id")
    private Habit habit;

    public Habit getHabit() {
        return habit;
    }

    public void setHabit(Habit habit) {
        this.habit = habit;
    }

    public DailyLog() {
    }

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
