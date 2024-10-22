package controller.employee;

import controller.item.ItemController;
import controller.util.Crudutil;
import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Employee;
import model.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeController implements EmployeeService {

    public static EmployeeController getInstance(){
        return new EmployeeController();
    }

    @Override
    public boolean addEmployee(Employee employee) {
        String SQL = "INSERT INTO employee VALUES(?,?,?,?)";
        try {

            Object exute = Crudutil.execute(SQL,
                    employee.getEmpId(),
                    employee.getEmpName(),
                    employee.getEmpAddress(),
                    employee.getEmpAge()
            );
            return true;



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ObservableList<Employee> getAllItems() {
        ObservableList<Employee> employeeObservableList = FXCollections.observableArrayList();
        String SQL = "SELECT * FROM employee";
        try {
            ResultSet resultSet = Crudutil.execute(SQL);

            while (resultSet.next()) {
                employeeObservableList.add(new Employee(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4)
                ));
            }
            return employeeObservableList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updateEmployee(Employee empId) {
        boolean isUpdate;
        String SQL = "UPDATE employee SET empName = ?, empAddress = ?, empAge = ? WHERE empId = ?";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement psTm = connection.prepareStatement(SQL);


            psTm.setObject(1, empId.getEmpName());
            psTm.setObject(2, empId.getEmpAddress());
            psTm.setObject(3, empId.getEmpAge());
            psTm.setObject(4, empId.getEmpId());
            isUpdate = psTm.executeUpdate() > 0;



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if(isUpdate) {
            return true;

        }
        return false;
    }

    @Override
    public boolean deleteEmployee(String empId) {
        boolean isDelete;
        try {
            isDelete = DBConnection.getInstance().getConnection().createStatement().executeUpdate("DELETE FROM employee WHERE empId = '" + empId + "'") > 0;




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if(isDelete){
            return true;
        }
        return false;
    }

    @Override
    public Employee searchEmployee(String empId) {
        String SQL = "SELECT * FROM employee WHERE empId='" + empId + "'";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement psTm = connection.prepareStatement(SQL);
            ResultSet resultSet = psTm.executeQuery();
            while (resultSet.next()) {
                return new Employee(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4)
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }
}
