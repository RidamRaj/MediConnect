package com.wecp.progressive.service.impl;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
=======
>>>>>>> 019e7c054c96d98348ae4f62ab966f45081a54e8
import java.util.List;

import com.wecp.progressive.entity.Doctor;
import com.wecp.progressive.service.DoctorService;

public class DoctorServiceImplArraylist implements DoctorService{

<<<<<<< HEAD
    private static List<Doctor> doctorList = new ArrayList<>();

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorList;
=======
    @Override
    public List<Doctor> getAllDoctors() {
        return List.of();
>>>>>>> 019e7c054c96d98348ae4f62ab966f45081a54e8
    }

    @Override
    public Integer addDoctor(Doctor doctor) {
<<<<<<< HEAD
        doctorList.add(doctor);
        return doctorList.size();
=======
        return -1;
>>>>>>> 019e7c054c96d98348ae4f62ab966f45081a54e8
    }

    @Override
    public List<Doctor> getDoctorSortedByExperience() {
<<<<<<< HEAD
        List<Doctor> sortedList = new ArrayList<>(doctorList);
        // Collections.sort(sortedList, (p1, p2) -> Integer.compare(p1.getYearsOfExperience(), p2.getYearsOfExperience()));
        sortedList.sort(Comparator.comparingInt(Doctor::getYearsOfExperience));
        return sortedList;
=======
        return List.of();
>>>>>>> 019e7c054c96d98348ae4f62ab966f45081a54e8
    }

}