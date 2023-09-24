package com.medicalRecords.MedicalRecordsSpringBootAPIRest.Repository;

import com.medicalRecords.MedicalRecordsSpringBootAPIRest.Model.RecordMedical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordMedicalRepository extends JpaRepository<RecordMedical,Long> {

    public List<RecordMedical> findByPublicationId(long recordMedicalId);
}
