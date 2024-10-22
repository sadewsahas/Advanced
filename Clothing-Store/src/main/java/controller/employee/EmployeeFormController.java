package controller.employee;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Employee;
import model.Item;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class EmployeeFormController implements Initializable {

    @FXML
    private TableColumn colAddress;

    @FXML
    private TableColumn colAge;

    @FXML
    private TableColumn colID;

    @FXML
    private TableColumn colName;

    @FXML
    private TableView tblEmployee;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtAge;

    @FXML
    private JFXTextField txtID;

    @FXML
    private JFXTextField txtName;

    List<Employee> employeeList = new ArrayList<>() ;

    EmployeeService employeeService = new EmployeeController();

    @FXML
    void btnOnActionAdd(ActionEvent event) {
        Employee employee = new Employee(
                txtID.getText(),
                txtName.getText(),
                txtAge.getText(),
                txtAddress.getText()


        );



        if(employeeService.addEmployee(employee)){
            loadTable();
            new Alert(Alert.AlertType.INFORMATION, "Employee Added").show();
        }else{
            new Alert(Alert.AlertType.INFORMATION, "Employee Not Added").show();
        }
    }

    @FXML
    void btnOnActionDelete(ActionEvent event) {
        if(employeeService.deleteEmployee(txtID.getText())){
            loadTable();
            new Alert(Alert.AlertType.INFORMATION, "Employee Deleted").show();
        }else{
            new Alert(Alert.AlertType.INFORMATION, "Employee Not Deleted").show();
        }
    }

//    @FXML
//    void btnOnActionSearch(ActionEvent event) {
//
//    }

    @FXML
    void btnOnActionUpdate(ActionEvent event) {
        Employee employee = new Employee(
                txtID.getText(),
                txtName.getText(),
                txtAge.getText(),
                txtAddress.getText()


        );

        if (employeeService.updateEmployee(employee)) {
            loadTable();
            new Alert(Alert.AlertType.INFORMATION, "Employee Updated").show();
        } else {
            new Alert(Alert.AlertType.INFORMATION, "Employee Not Updated").show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colID.setCellValueFactory(new PropertyValueFactory<>("empId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("empName"));
        colAge.setCellValueFactory(new PropertyValueFactory<>("empAge"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("empAddress"));


        loadTable();





        tblEmployee.getSelectionModel().selectedItemProperty().addListener((observableValue, oldVal, newVal) ->{
            if(newVal != null) {
                addValueText((Employee) newVal);
            }
        } );
    }


    private void addValueText(Employee newVal) {
        txtID.setText(newVal.getEmpId());
        txtName.setText(newVal.getEmpName());
        txtAge.setText(String.valueOf(newVal.getEmpAge()));
        txtAddress.setText(newVal.getEmpAddress());


    }

    private void loadTable(){
        ObservableList<Employee> employeesObservableList = FXCollections.observableArrayList();

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clothing_store", "root", "sadev233");

            PreparedStatement psTm =
                    connection.prepareStatement("SELECT * FROM employee");

            ResultSet resultSet = psTm.executeQuery();

            while (resultSet.next()) {
                    Employee employee = new Employee(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4)
                    );
                employeesObservableList.add(employee);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        tblEmployee.setItems(employeesObservableList);
    }
}
