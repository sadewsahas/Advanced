package controller.employee;

import javafx.collections.ObservableList;
import model.Employee;
import model.Item;

public interface EmployeeService {
    boolean addEmployee(Employee employee);

    ObservableList<Employee> getAllItems();

    boolean updateEmployee(Employee empId);

    boolean deleteEmployee(String empId);

    Employee searchEmployee(String empId);
}
