package org.project.habit_tracker.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "habits")
public class Habit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer habitId;

    @Column(name = "habit_name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "date_created")
    private LocalDate dateCreated;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;


    @OneToMany(mappedBy = "habit", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<DailyLog> logs;

    public Habit() {
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<DailyLog> getLogs() {
        return logs;
    }

    public void setLogs(List<DailyLog> logs) {
        this.logs = logs;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }
}
