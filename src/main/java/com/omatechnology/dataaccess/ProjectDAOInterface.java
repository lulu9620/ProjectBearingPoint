package com.omatechnology.dataaccess;

import com.omatechnology.entities.Project;

import java.util.List;

public interface ProjectDAOInterface {
    void insert(Project project);

    List<Project> getProjectsByUsername(String username);
}
