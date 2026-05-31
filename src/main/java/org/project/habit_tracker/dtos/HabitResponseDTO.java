package org.project.habit_tracker.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class HabitResponseDTO {
    @NotNull
    private Integer habitId;
    @NotBlank
    private String name;
    private String desc;
    @NotBlank
    private LocalDate dateCreated;


    public HabitResponseDTO(Integer habitId, String name, String desc,LocalDate dateCreated) {
        this.habitId = habitId;
        this.name = name;
        this.desc = desc;
        this.dateCreated = dateCreated;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Integer getHabitId() {
        return habitId;
    }

    public void setHabitId(Integer habitId) {
        this.habitId = habitId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
