package model;


import lombok.*;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {
    private String empId;
    private String empName;
    private String empAddress;
    private String empAge;
}
