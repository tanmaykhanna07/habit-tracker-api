package org.project.habit_tracker.dtos;

import jakarta.validation.constraints.NotBlank;

public class HabitRequestDTO {
    @NotBlank
    private String name;
    private String desc;

    public HabitRequestDTO(String name, String desc) {
        this.name = name;
        this.desc = desc;
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
