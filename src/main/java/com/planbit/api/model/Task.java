package com.planbit.api.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "task")
public class Task extends TimeObject {

    public Task() {}

    public Task(String name, LocalDateTime startTime, LocalDateTime endTime) {
        super(name, startTime, endTime);
    }

}
