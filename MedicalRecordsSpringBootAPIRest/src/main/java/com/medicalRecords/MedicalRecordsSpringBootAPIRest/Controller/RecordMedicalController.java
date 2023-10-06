package com.medicalRecords.MedicalRecordsSpringBootAPIRest.Controller;

import com.medicalRecords.MedicalRecordsSpringBootAPIRest.DTO.RecordMedicalDTO;
import com.medicalRecords.MedicalRecordsSpringBootAPIRest.Model.RecordMedical;
import com.medicalRecords.MedicalRecordsSpringBootAPIRest.Services.RecordMedicalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecordMedicalController {

    @Autowired
    private RecordMedicalService recordMedicalService;

    @PostMapping({"/patients/{patientId}/recordMedical/save"})
    public ResponseEntity<RecordMedicalDTO> saveRecordMedical(
            @PathVariable(value = "patientId") Long patientId ,
            @Valid @RequestBody RecordMedicalDTO rm){

        return  new ResponseEntity<>(
                recordMedicalService.createRecordMedical(patientId,rm), HttpStatus.CREATED
        );
    }

    @GetMapping({"/patients/{patientId}/recordMedical/get"})
    public List<RecordMedicalDTO> getRmByPatientId(@PathVariable(value = "patientId") long patientId){
        return  recordMedicalService.getRecordMedicalByPatientId(patientId);
    }

    @GetMapping({"/patients/{patientId}/recordMedical/get/{recordMedicalId}"})
    public ResponseEntity<RecordMedicalDTO> getRmByIdAndPId(
            @PathVariable(value = "patientId") Long patientId,
            @PathVariable(value = "recordMedicalId") Long rmId){
        return  new ResponseEntity<>(
                recordMedicalService.getRecordMedicalById(patientId,rmId), HttpStatus.OK);
    }

    @PutMapping({"/patients/{patientId}/recordMedical/update/{recordMedicalId}"})
    public ResponseEntity<RecordMedicalDTO> updateRecordMedical(
            @PathVariable(value = "patientId") Long patientId,
            @PathVariable(value = "recordMedicalId") Long rmId,
            @Valid @RequestBody RecordMedical rm){

        return  new ResponseEntity<>(
                recordMedicalService.updateRecordMedical(patientId,rmId,rm), HttpStatus.OK);
    }

    @DeleteMapping({"/patients/{patientId}/recordMedical/delete/{recordMedicalId}"})
    public ResponseEntity<String> deleteRecordMedical(
            @PathVariable(value = "patientId") Long patientId,
            @PathVariable(value = "recordMedicalId") Long rmId){

        recordMedicalService.deleteRecordMedical(patientId,rmId);

        return new ResponseEntity<>("DELETING RECORD MEDICAL",HttpStatus.OK);
    }

}
