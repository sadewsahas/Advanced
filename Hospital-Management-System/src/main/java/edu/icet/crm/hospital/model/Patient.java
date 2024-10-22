package edu.icet.crm.hospital.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.PrimitiveIterator;
import java.util.SplittableRandom;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Patient {
    private Integer id;
    private String name;
    private String nic;
    private String address;
    private String bloodgroup;
    private String gender;
    private String contact;
    private String category;
    private String age;
    private String allergies;
    private String note;
}
