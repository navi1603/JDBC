package service;

import bl.Utile;
import dao.EmployeeDAO;
import entity.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService extends Utile implements EmployeeDAO {

    Connection connection = getConnection();

    @Override
    public void create(Employee employee) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql ="INSERT INTO EMPLOYEE (ID, FIRST_NAME, LAST_NAME, BIRTHDAY_DATE, ADDRESS_ID) VALUES (?, ?, ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, employee.getId());
            preparedStatement.setString(2, employee.getFirstName());
            preparedStatement.setString(3, employee.getLastName());
            preparedStatement.setDate(4, employee.getBirthDay());
            preparedStatement.setLong(5, employee.getAddressId());

            preparedStatement.executeUpdate();

        }catch(SQLException e) {
            e.printStackTrace();
        }finally {
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null) {
                connection.close();
            }

        }

    }

    @Override
    public List<Employee> getAll() throws  SQLException {
        List<Employee> employeeList = new ArrayList<>();

        Statement statement = null;

        String sql = "SELECT ID, FIRST_NAME, LAST_NAME, birthday_date, ADDRESS_ID FROM EMPLOYEE";

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                Employee employee = new Employee();
                employee.setId(resultSet.getLong("ID"));
                employee.setFirstName(resultSet.getString("FIRST_NAME"));
                employee.setLastName(resultSet.getString("LAST_NAME"));
                employee.setBirthDay(resultSet.getDate("birthday_date"));
                employee.setAddressId(resultSet.getLong("ADDRESS_ID"));

                employeeList.add(employee);

            }


        }catch (SQLException e){
            e.printStackTrace();

        }finally {
            if(statement != null){
                statement.close();
            }
            if (connection != null){
                connection.close();
            }
        }

        return employeeList;
    }

    @Override
    public Employee getById(Long id) throws  SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "SELECT FIRST_NAME, LAST_NAME, BIRTHDAY_DATE, " +
                        "ADDRESS_ID FROM EMPLOYEE WHERE ID=?";

        Employee employee = new Employee();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            employee.setId(resultSet.getLong("ID"));
            employee.setFirstName(resultSet.getString("FIRST_NAME"));
            employee.setLastName(resultSet.getString("LAST_NAME"));
            employee.setBirthDay(resultSet.getDate("BIRTHDAY_DATA"));
            employee.setAddressId(resultSet.getLong("ADDRESS_ID"));

            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        }

        return employee;
    }

    @Override
    public void update(Employee employee) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE EMPLOYEE SET ID=?, FIRST_NAME=?, LAST_NAME=?, " +
                "       BIRTHDAY_DATE=?, ADDRESS_ID=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, employee.getId());
            preparedStatement.setString(2, employee.getFirstName());
            preparedStatement.setString(3, employee.getLastName());
            preparedStatement.setDate(4, employee.getBirthDay());
            preparedStatement.setLong(5, employee.getAddressId());

            preparedStatement.executeUpdate();

        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(preparedStatement !=null){
                preparedStatement.close();
            }
            if(connection !=null){
                connection.close();
            }
        }

    }

    @Override
    public void remove(Employee employee) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql ="DELETE FROM EMPLOYEE WHERE ID=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, employee.getId());
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        }


    }
}
