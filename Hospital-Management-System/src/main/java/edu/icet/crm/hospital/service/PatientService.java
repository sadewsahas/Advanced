package edu.icet.crm.hospital.service;

import edu.icet.crm.hospital.model.Patient;

import java.util.List;

public interface PatientService {

    List<Patient> getPatient();

    void addPatient(Patient patient);
}
