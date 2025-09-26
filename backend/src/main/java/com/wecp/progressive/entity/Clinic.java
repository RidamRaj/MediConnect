package com.wecp.progressive.entity;

import javax.persistence.*;

@Entity
public class Clinic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int clinicId;
    private String clinicName;
    private String location;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
    private String contactNumber;
    private int establishedYear;

    public Clinic() {

    }

    public Clinic(int clinicId, String clinicName, String location, int doctorId, String contactNumber, int establishedYear) {
        this.clinicId = clinicId;
        this.clinicName = clinicName;
        this.location = location;
        this.doctor = new Doctor();
		this.doctor.setDoctorId(doctorId);
        this.contactNumber = contactNumber;
        this.establishedYear = establishedYear;
    }

    public int getClinicId() {
        return clinicId;
    }

    public void setClinicId(int clinicId) {
        this.clinicId = clinicId;
    }

    public String getClinicName() {
        return clinicName;
    }

    public void setClinicName(String clinicName) {
        this.clinicName = clinicName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public int getEstablishedYear() {
        return establishedYear;
    }

    public void setEstablishedYear(int establishedYear) {
        this.establishedYear = establishedYear;
    }
}