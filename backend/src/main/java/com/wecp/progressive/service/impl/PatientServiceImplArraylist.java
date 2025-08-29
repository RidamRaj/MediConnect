package com.wecp.progressive.service.impl;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
=======
>>>>>>> 019e7c054c96d98348ae4f62ab966f45081a54e8
import java.util.List;

import com.wecp.progressive.entity.Patient;
import com.wecp.progressive.service.PatientService;

public class PatientServiceImplArraylist implements PatientService{

<<<<<<< HEAD
    private static List<Patient> patientList = new ArrayList<>();
    @Override
    public List<Patient> getAllPatients() {
        return patientList;
=======
    @Override
    public List<Patient> getAllPatients() {
        return List.of();
>>>>>>> 019e7c054c96d98348ae4f62ab966f45081a54e8
    }

    @Override
    public Integer addPatient(Patient patient) {
<<<<<<< HEAD
        patientList.add(patient);
        return patientList.size();
=======
        return -1;
>>>>>>> 019e7c054c96d98348ae4f62ab966f45081a54e8
    }

    @Override
    public List<Patient> getAllPatientSortedByName() {
<<<<<<< HEAD
       List<Patient> sortedList = new ArrayList<>(patientList);
    //    Collections.sort(sortedList, (p1, p2) -> p1.getFullName().compareTo(p2.getFullName()));
        sortedList.sort(Comparator.comparing(Patient::getFullName));

       return sortedList;
=======
        return List.of();
>>>>>>> 019e7c054c96d98348ae4f62ab966f45081a54e8
    }

}