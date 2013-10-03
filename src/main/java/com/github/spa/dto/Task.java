package com.github.spa.dto;

import javax.persistence.*;

@Entity(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Basic
    private String name;

    @Basic
    private String owner;

    @Basic
    private String createdDate;

    public Task(String name, String owner, String createdDate) {
        this.name = name;
        this.owner = owner;
        this.createdDate = createdDate;
    }

    public Task() {
    }

    public String getOwner() {
        return owner;
    }

    public Long getId() {
        return id;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public String getName() {
        return name;
    }
}
