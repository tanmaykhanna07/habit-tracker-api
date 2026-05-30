package org.project.habit_tracker.dtos;

import jakarta.validation.constraints.NotBlank;

public class HabitRequestDTO {
    @NotBlank
    private String name;
    private String desc;
    @NotBlank
    private String username;

    public HabitRequestDTO(String name, String desc, String username) {
        this.name = name;
        this.desc = desc;
        this.username = username;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
