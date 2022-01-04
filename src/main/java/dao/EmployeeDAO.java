package dao;

import entity.Address;
import entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    //create
    void create (Employee employee);

    //read
    List<Employee> getAll();

    Employee getById (Long id);

    //update
    void update (Employee employee);

    //delete
    void remove(Employee employee);
}
