package com.medicalRecords.MedicalRecordsSpringBootAPIRest.Repository;

import com.medicalRecords.MedicalRecordsSpringBootAPIRest.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository  extends JpaRepository<Patient,Long> {
}
