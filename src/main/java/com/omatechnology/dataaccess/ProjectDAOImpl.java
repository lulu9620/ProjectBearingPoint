package com.omatechnology.dataaccess;

import com.omatechnology.entities.Project;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectDAOImpl implements ProjectDAOInterface {
    private DatabaseConnection databaseConnection = new DatabaseConnection();

    @Override
    public void insert(Project project) {
        try {
            databaseConnection.connect();
            String sql = "INSERT INTO projects(Name,Manager,Client,ReleaseDate,Description,Status) " +
                    "VALUES(?,?,?,?,?,?)";
            PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(sql);

            preparedStatement.setString(1, project.getName());
            preparedStatement.setString(2, project.getManager());
            preparedStatement.setString(3, project.getClient());
            preparedStatement.setDate(4, project.getReleaseDate());
            preparedStatement.setString(5, project.getDescription());
            preparedStatement.setString(6, project.getStatus());

            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            databaseConnection.close();
        }
    }

    @Override
    public List<Project> getProjectsByUsername(String username) {
        List<Project> projectList = new ArrayList<>();
        try {
            databaseConnection.connect();
            String sql = "select p.Name, p.Manager, p.Client, p.ReleaseDate, p.Description, p.Status " +
                    "from projects p inner join projectmembers pm on p.ID=pm.ProjectID " +
                    "where pm.Username=? ";
            PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("Name");
                String manager = rs.getString("Manager");
                String client = rs.getString("Client");
                Date releaseDate = rs.getDate("ReleaseDate");
                String description = rs.getString("Description");
                String status = rs.getString("Status");
                Project project = new Project(name, manager, client, releaseDate, description, status);
                projectList.add(project);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            String sql = "select p.Name, p.Manager, p.Client, p.ReleaseDate, p.Description, p.Status " +
                    "from projects p " +
                    "where p.Manager=? ";
            PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("Name");
                String manager = rs.getString("Manager");
                String client = rs.getString("Client");
                Date releaseDate = rs.getDate("ReleaseDate");
                String description = rs.getString("Description");
                String status = rs.getString("Status");
                Project project = new Project(name, manager, client, releaseDate, description, status);
                projectList.add(project);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        databaseConnection.close();
        return projectList;
    }
}
