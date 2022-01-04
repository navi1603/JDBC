package dao;

import entity.Address;
import entity.EmplProj;

import java.util.List;

public interface EmplProjDAO {
    //create
    void create (EmplProj emplProj);

    //read
    List<EmplProj> getAll();

    EmplProj getById (Long EmployeeId, Long ProjectId);

    //update
    void update (Address address);

    //delete
    void remove(Address address);
}
