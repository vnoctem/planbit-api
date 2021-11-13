package com.planbit.api.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
abstract class TimeObject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @Column(name = "start_time")
    private LocalDateTime startTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    public TimeObject() {}

    public TimeObject(String name, LocalDateTime startTime, LocalDateTime endTime) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public long getId() {return id;}

    public void setId(long id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public LocalDateTime getStartTime() {return startTime;}

    public void setStartTime(LocalDateTime startTime) {this.startTime = startTime;}

    public LocalDateTime getEndTime() {return endTime;}

    public void setEndTime(LocalDateTime endTime) {this.endTime = endTime;}

    @Override
    public String toString() {
        return "TimeObject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
