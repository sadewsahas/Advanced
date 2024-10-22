package edu.icet.crm.hospital.service.impl;

import edu.icet.crm.hospital.model.Patient;
import edu.icet.crm.hospital.service.PatientService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    List<Patient> patientList = new ArrayList<>();

    @Override
    public List<Patient> getPatient() {
        return patientList;
    }

    @Override
    public void addPatient(Patient patient){
        patientList.add(patient);
    }
}
