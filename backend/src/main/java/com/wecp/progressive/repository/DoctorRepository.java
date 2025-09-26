package com.wecp.progressive.repository;

import com.wecp.progressive.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

    Doctor findByDoctorId(int doctorId);

    Doctor findByEmail(String email);
}
