package com.medicalRecords.MedicalRecordsSpringBootAPIRest.Services;

import com.medicalRecords.MedicalRecordsSpringBootAPIRest.DTO.RecordMedicalDTO;
import com.medicalRecords.MedicalRecordsSpringBootAPIRest.Exceptions.MedicalRecordsAppException;
import com.medicalRecords.MedicalRecordsSpringBootAPIRest.Exceptions.ResourceNotFoundException;
import com.medicalRecords.MedicalRecordsSpringBootAPIRest.Model.Patient;
import com.medicalRecords.MedicalRecordsSpringBootAPIRest.Model.RecordMedical;
import com.medicalRecords.MedicalRecordsSpringBootAPIRest.Repository.PatientRepository;
import com.medicalRecords.MedicalRecordsSpringBootAPIRest.Repository.RecordMedicalRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecordMedicalServiceImp implements RecordMedicalService{

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RecordMedicalRepository medicalRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public RecordMedicalDTO createRecordMedical(Long patientId, RecordMedicalDTO rDTO) {
        Patient p = this.patientRepository.findById(patientId).
                orElseThrow(()-> new ResourceNotFoundException("Patient","id",patientId));
        RecordMedical rM =new RecordMedical(p,rDTO.getId(),rDTO.getRecordDate()
                , rDTO.getFamilyHistory(),rDTO.getPersonalHistory(),rDTO.getReasonConsult()
                ,rDTO.getReasonConsult(),rDTO.getMedicinalPrescription());
        RecordMedical newRM = medicalRepository.save(rM);
        return new RecordMedicalDTO(newRM.getId(),newRM.getRecordDate()
                , newRM.getFamilyHistory(),newRM.getPersonalHistory(),newRM.getReasonConsult()
                ,newRM.getReasonConsult(),newRM.getMedicinalPrescription());
    }

    @Override
    public List<RecordMedicalDTO> getRecordMedicalByPatientId(Long patientId) {
        Patient p = this.patientRepository.findById(patientId).
                orElseThrow(()-> new ResourceNotFoundException("Patient","id",patientId));

        List<RecordMedical>recordMedicals = medicalRepository.findByPatientId(patientId);

        return recordMedicals.stream().map(recordMedical ->
                modelMapper.map(recordMedical, RecordMedicalDTO.class)).collect(Collectors.toList());
    }

    @Override
    public RecordMedicalDTO getRecordMedicalById(Long patientId, Long recordMedicalId) {

        Patient p = this.patientRepository.findById(patientId).
                orElseThrow(()-> new ResourceNotFoundException("Patient","id",patientId));

        RecordMedical rm = this.medicalRepository.findById(recordMedicalId).
                orElseThrow(()-> new ResourceNotFoundException("Record Medical","id",recordMedicalId));

        if(! rm.getPatient().getId().equals(p.getId())){
            throw new MedicalRecordsAppException(HttpStatus.BAD_REQUEST,
                    "Record medical does not belong to patient");
        }
        return modelMapper.map(rm, RecordMedicalDTO.class);

    }

    @Override
    public RecordMedicalDTO updateRecordMedical(Long patientId, Long recordMedicalId , RecordMedical updateRM) {
        Patient p = this.patientRepository.findById(patientId).
                orElseThrow(()-> new ResourceNotFoundException("Patient","id",patientId));

        RecordMedical rm = this.medicalRepository.findById(recordMedicalId).
                orElseThrow(()-> new ResourceNotFoundException("Record Medical","id",recordMedicalId));

        if(! rm.getPatient().getId().equals(p.getId())){
            throw new MedicalRecordsAppException(HttpStatus.BAD_REQUEST,
                    "Record medical does not belong to patient");
        }

        rm.setAllergies(updateRM.getAllergies());
        rm.setRecordDate(updateRM.getRecordDate());
        rm.setFamilyHistory(updateRM.getFamilyHistory());
        rm.setMedicinalPrescription(updateRM.getMedicinalPrescription());
        rm.setPersonalHistory(updateRM.getPersonalHistory());
        rm.setReasonConsult(updateRM.getReasonConsult());
        medicalRepository.save(rm);
        return modelMapper.map(rm, RecordMedicalDTO.class);
    }

    @Override
    public void deleteRecordMedical(Long patientId, Long recordMedicalId) {
        Patient p = this.patientRepository.findById(patientId).
                orElseThrow(()-> new ResourceNotFoundException("Patient","id",patientId));

        RecordMedical rm = this.medicalRepository.findById(recordMedicalId).
                orElseThrow(()-> new ResourceNotFoundException("Record Medical","id",recordMedicalId));

        if(! rm.getPatient().getId().equals(p.getId())){
            throw new MedicalRecordsAppException(HttpStatus.BAD_REQUEST,
                    "Record medical does not belong to patient");
        }

        medicalRepository.delete(rm);
    }
}
