package com.planbit.api.model;


import javax.persistence.Entity;
import java.time.LocalDateTime;


@Entity
public class Task {

    private long id;
    private String name;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public long getId() {return id;}

    public void setId(long id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public LocalDateTime getStartTime() {return startTime;}

    public void setStartTime(LocalDateTime startTime) {this.startTime = startTime;}

    public LocalDateTime getEndTime() {return endTime;}

    public void setEndTime(LocalDateTime endTime) {this.endTime = endTime;}
}
