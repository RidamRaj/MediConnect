package com.wecp.progressive.controller;

import com.wecp.progressive.entity.Clinic;
import com.wecp.progressive.service.impl.ClinicServiceImplJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clinic")
public class ClinicController {

    @Autowired
    ClinicServiceImplJpa clinicServiceImplJpa;

    @GetMapping
    public ResponseEntity<List<Clinic>> getAllClinics() {
        try {
            List<Clinic> clinicList = clinicServiceImplJpa.getAllClinics();
            return new ResponseEntity<>(clinicList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{clinicId}")
    public ResponseEntity<?> getClinicById(@PathVariable int clinicId) {
        try {
            Clinic clinic = clinicServiceImplJpa.getClinicById(clinicId);
            return new ResponseEntity<>(clinic, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<?> addClinic(@RequestBody Clinic clinic) {
        try {
            int clinicId = clinicServiceImplJpa.addClinic(clinic);
            return new ResponseEntity<>(clinicId, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{clinicId}")
    public ResponseEntity<?> updateClinic(@PathVariable int clinicId, @RequestBody Clinic clinic) {
        try {
            clinic.setClinicId(clinicId);
            clinicServiceImplJpa.updateClinic(clinic);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{clinicId}")
    public ResponseEntity<?> deleteClinic(@PathVariable int clinicId) {
        try {
            clinicServiceImplJpa.deleteClinic(clinicId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/location/{location}")
    public ResponseEntity<?> getAllClinicByLocation(@PathVariable String location) {
        try {
            List<Clinic> clinicList = clinicServiceImplJpa.getAllClinicByLocation(location);
            return new ResponseEntity<>(clinicList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<?> getAllClinicByDoctorId(@PathVariable int doctorId) {
        try {
            List<Clinic> clinicList = clinicServiceImplJpa.getAllClinicByDoctorId(doctorId);
            return new ResponseEntity<>(clinicList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
