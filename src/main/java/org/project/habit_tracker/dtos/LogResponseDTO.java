package org.project.habit_tracker.dtos;

import org.project.habit_tracker.enums.Status;

import java.time.LocalDate;

public class LogResponseDTO {
    private Integer logId;
    private LocalDate date;
    private Status status;
    private Integer habitId;

    public LogResponseDTO(Integer logId, LocalDate date, Status status, Integer habitId) {
        this.logId = logId;
        this.date = date;
        this.status = status;
        this.habitId = habitId;
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

    public Integer getHabitId() {
        return habitId;
    }

    public void setHabitId(Integer habitId) {
        this.habitId = habitId;
    }
}