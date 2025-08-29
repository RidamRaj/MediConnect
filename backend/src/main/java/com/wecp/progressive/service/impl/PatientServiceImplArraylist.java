package com.wecp.progressive.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.wecp.progressive.entity.Patient;
import com.wecp.progressive.service.PatientService;

public class PatientServiceImplArraylist implements PatientService{

    private static List<Patient> patientList = new ArrayList<>();
    @Override
    public List<Patient> getAllPatients() {
        return patientList;
    }

    @Override
    public Integer addPatient(Patient patient) {
        patientList.add(patient);
        return patientList.size();
    }

    @Override
    public List<Patient> getAllPatientSortedByName() {
       List<Patient> sortedList = new ArrayList<>(patientList);
    //    Collections.sort(sortedList, (p1, p2) -> p1.getFullName().compareTo(p2.getFullName()));
        sortedList.sort(Comparator.comparing(Patient::getFullName));

       return sortedList;
    }

}