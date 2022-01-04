package dao;

import entity.Address;
import entity.Project;

import java.util.List;

public interface ProjectDAO {

    //create
    void create (Project project);

    //read
    List<Project> getAll();

    Project getById (Long id);

    //update
    void update (Project project);

    //delete
    void remove(Project project);
}
