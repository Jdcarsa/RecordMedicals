package com.medicalRecords.MedicalRecordsSpringBootAPIRest.Controller;

import com.medicalRecords.MedicalRecordsSpringBootAPIRest.DTO.PatientDTO;
import com.medicalRecords.MedicalRecordsSpringBootAPIRest.DTO.ResponsePatients;
import com.medicalRecords.MedicalRecordsSpringBootAPIRest.Model.Patient;
import com.medicalRecords.MedicalRecordsSpringBootAPIRest.Services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping({"/patients/save"})
    public ResponseEntity<PatientDTO> savePatient(@RequestBody PatientDTO patientDTO){
        return new ResponseEntity<>(patientService.createPatient(patientDTO), HttpStatus.CREATED);
    }

    @GetMapping({"/patients/findAll"})
    public ResponsePatients findAll( @RequestParam(value = "pageNumber" , defaultValue = "0",required = false) int pageNumber
            ,@RequestParam(value="pageSize", defaultValue = "5",required = false) int measurePage
            ,@RequestParam(value = "sortBy" , defaultValue = "id" , required = false) String sortBy
            ,@RequestParam(value = "sortDir" , defaultValue = "asc" , required = false) String sortDir){
        return patientService.findAll(pageNumber,measurePage,sortBy, sortDir);
    }

    @GetMapping({"/patients/findById/{id}"})
    public ResponseEntity<PatientDTO> findById(@PathVariable(name = "id") long id){
        return new ResponseEntity<>(patientService.getPatientById(id), HttpStatus.ACCEPTED);
    }

    @PutMapping({"/patients/update/{id}"})
    public ResponseEntity<Patient> update(@RequestBody PatientDTO p,
                                          @PathVariable(name = "id") long id){
        return ResponseEntity.ok(patientService.updatePatient(p,id));
    }

    @DeleteMapping({"/patients/delete/{id}"})
    public ResponseEntity<String> delete(@PathVariable(name = "id") long id){
        patientService.deletePatient(id);
        return new ResponseEntity<>("DELETING PUBLICATION",HttpStatus.OK);
    }


}
