package org.project.habit_tracker.dtos;

import jakarta.validation.constraints.NotNull;
import org.project.habit_tracker.enums.Status;

import java.util.Date;

public class LogRequestDTO {
    @NotNull
    private Date date;
    @NotNull
    private Status status;
    @NotNull
    private Integer habitId;

    public LogRequestDTO(Date date, Status status, Integer habitId) {
        this.date = date;
        this.status = status;
        this.habitId = habitId;
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
