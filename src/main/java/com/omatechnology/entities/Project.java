package com.omatechnology.entities;

import java.sql.Date;

public class Project {

    private String name;
    private String manager;
    private String client;
    private Date releaseDate;
    private String description;
    private String status;


    public Project(String name, String manager, String client, Date releaseDate, String description, String status) {
        this.setName(name);
        this.setManager(manager);
        this.setClient(client);
        this.setReleaseDate(releaseDate);
        this.setDescription(description);
        this.setStatus(status);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}