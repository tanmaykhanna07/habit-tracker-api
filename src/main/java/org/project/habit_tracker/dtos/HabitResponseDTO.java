package org.project.habit_tracker.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class HabitResponseDTO {
    @NotNull
    private Integer habitId;
    @NotBlank
    private String name;
    private String desc;
    @NotBlank
    private String username;

    public HabitResponseDTO(Integer habitId, String name, String desc, String username) {
        this.habitId = habitId;
        this.name = name;
        this.desc = desc;
        this.username = username;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
