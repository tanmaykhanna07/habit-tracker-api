package org.project.habit_tracker.dtos;

import jakarta.validation.constraints.NotNull;
import org.project.habit_tracker.enums.Status;

import java.util.Date;

public class LogResponseDTO {
    @NotNull
    private Integer logId;
    @NotNull
    private Date date;
    @NotNull
    private Status status;
    @NotNull
    private Integer habitId;

    public LogResponseDTO(Integer logId, Date date, Status status, Integer habitId) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
