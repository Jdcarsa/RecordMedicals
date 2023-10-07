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

    /**
     * The function saves a medical record for a specific patient.
     * 
     * @param patientId The patientId is a path variable 
     * that is extracted from the URL. It represents
     * the unique identifier of the patient for whom the medical record is being saved.
     * @param rm The parameter "rm" is of type RecordMedicalDTO
     *  and it represents the request body
     * containing the data for creating a new medical record.
     * @return The method is returning a ResponseEntity object 
     * containing a RecordMedicalDTO object and
     * an HTTP status code.
     */
    @PostMapping({"/patients/{patientId}/recordMedical/save"})
    public ResponseEntity<RecordMedicalDTO> saveRecordMedical(
            @PathVariable(value = "patientId") Long patientId ,
            @Valid @RequestBody RecordMedicalDTO rm){

        return  new ResponseEntity<>(
                recordMedicalService.createRecordMedical(patientId,rm), HttpStatus.CREATED
        );
    }

    /**
     * The function retrieves a list of medical records for a specific patient.
     * 
     * @param patientId The patientId is a path variable
     *  that is used to identify a specific patient.
     * It is passed as a parameter in the URL and is used 
     * to retrieve the medical records associated
     * with that patient.
     * @return The method is returning a List of RecordMedicalDTO objects.
     */
    @GetMapping({"/patients/{patientId}/recordMedical/get"})
    public List<RecordMedicalDTO> getRmByPatientId(@PathVariable(value = "patientId") long patientId){
        return  recordMedicalService.getRecordMedicalByPatientId(patientId);
    }

    /**
     * The function retrieves a specific medical record for a patient by their patient ID and the
     * medical record ID.
     * 
     * @param patientId The patientId is a Long value that 
     * represents the unique identifier of a
     * patient. It is used to specify which patient's record 
     * medical information is being requested.
     * @param rmId The "rmId" parameter represents the ID 
     * of the record medical that you want to
     * retrieve.
     * @return The method is returning a ResponseEntity 
     * object containing a RecordMedicalDTO object and
     * an HttpStatus code.
     */
    @GetMapping({"/patients/{patientId}/recordMedical/get/{recordMedicalId}"})
    public ResponseEntity<RecordMedicalDTO> getRmByIdAndPId(
            @PathVariable(value = "patientId") Long patientId,
            @PathVariable(value = "recordMedicalId") Long rmId){
        return  new ResponseEntity<>(
                recordMedicalService.getRecordMedicalById(patientId,rmId), HttpStatus.OK);
    }

    /**
     * The function updates a medical record for a specific patient.
     * 
     * @param patientId The patientId parameter is a Long value 
     * that represents the ID of the patient
     * whose medical record is being updated.
     * @param rmId The `rmId` parameter represents the ID of the 
     * record medical that needs to be
     * updated.
     * @param rm The parameter "rm" is of type RecordMedical 
     * and it represents the updated record
     * medical information that will be used to update the existing
     *  record medical entry in the
     * database.
     * @return The method is returning a ResponseEntity object containing a RecordMedicalDTO object.
     */
    @PutMapping({"/patients/{patientId}/recordMedical/update/{recordMedicalId}"})
    public ResponseEntity<RecordMedicalDTO> updateRecordMedical(
            @PathVariable(value = "patientId") Long patientId,
            @PathVariable(value = "recordMedicalId") Long rmId,
            @Valid @RequestBody RecordMedical rm){

        return  new ResponseEntity<>(
                recordMedicalService.updateRecordMedical(patientId,rmId,rm), HttpStatus.OK);
    }

    /**
     * This function deletes a record medical for a specific patient.
     * 
     * @param patientId The patientId is a Long value that represents
     *  the unique identifier of apatient. It is used to specify which 
     * patient's record medical should be deleted.
     * @param rmId The `rmId` parameter represents the ID of 
     * the record medical that needs to bedeleted.
     * @return The method is returning a ResponseEntity 
     * object with a String message "DELETING RECORD
     * MEDICAL" and an HTTP status code of OK (200).
     */
    @DeleteMapping({"/patients/{patientId}/recordMedical/delete/{recordMedicalId}"})
    public ResponseEntity<String> deleteRecordMedical(
            @PathVariable(value = "patientId") Long patientId,
            @PathVariable(value = "recordMedicalId") Long rmId){

        recordMedicalService.deleteRecordMedical(patientId,rmId);

        return new ResponseEntity<>("DELETING RECORD MEDICAL",HttpStatus.OK);
    }

}
