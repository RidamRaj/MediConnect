package com.wecp.progressive.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.wecp.progressive.entity.Doctor;
import com.wecp.progressive.service.DoctorService;

public class DoctorServiceImplArraylist implements DoctorService{

    private static List<Doctor> doctorList = new ArrayList<>();

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorList;
    }

    @Override
    public Integer addDoctor(Doctor doctor) {
        doctorList.add(doctor);
        return doctorList.size();
    }

    @Override
    public List<Doctor> getDoctorSortedByExperience() {
        List<Doctor> sortedList = new ArrayList<>(doctorList);
        // Collections.sort(sortedList, (p1, p2) -> Integer.compare(p1.getYearsOfExperience(), p2.getYearsOfExperience()));
        sortedList.sort(Comparator.comparingInt(Doctor::getYearsOfExperience));
        return sortedList;
    }

}