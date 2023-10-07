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

    /**
     * The function saves a patient by creating a new patient object and returning it with a HTTP
     * status of 201 (Created).
     * 
     * @param patientDTO The patientDTO parameter is an object of type PatientDTO that represents the
     * patient data to be saved. It is annotated with @RequestBody, which means that the patient data
     * will be passed in the request body of the HTTP POST request.
     * @return The method is returning a ResponseEntity object with a generic type of PatientDTO.
     */
    @PostMapping({"/patients/save"})
    public ResponseEntity<PatientDTO> savePatient(@RequestBody PatientDTO patientDTO){
        return new ResponseEntity<>(patientService.createPatient(patientDTO), HttpStatus.CREATED);
    }

/**
 * This Java function returns a ResponsePatients object containing a list of all patients, with
 * optional pagination and sorting parameters.
 * 
 * @param pageNumber The pageNumber parameter is used to specify the page number of the results to
 * retrieve. It has a default value of 0.
 * @param measurePage The "measurePage" parameter is used to specify the number of patients to be
 * displayed per page in the response. The default value is set to 5, but it can be overridden by
 * providing a different value in the request.
 * @param sortBy The "sortBy" parameter is used to specify the field by which the patients should be
 * sorted. The default value is "id", which means the patients will be sorted by their ID.
 * @param sortDir The sortDir parameter is used to specify the sorting direction for the results. It
 * can have two possible values: "asc" for ascending order and "desc" for descending order.
 * @return The method is returning a ResponsePatients object.
 */
    @GetMapping({"/patients/findAll"})
    public ResponsePatients findAll( @RequestParam(value = "pageNumber" , defaultValue = "0",required = false) int pageNumber
            ,@RequestParam(value="pageSize", defaultValue = "5",required = false) int measurePage
            ,@RequestParam(value = "sortBy" , defaultValue = "id" , required = false) String sortBy
            ,@RequestParam(value = "sortDir" , defaultValue = "asc" , required = false) String sortDir){
        return patientService.findAll(pageNumber,measurePage,sortBy, sortDir);
    }

/**
 * The function findById retrieves a patient by their ID and
 *  returns a ResponseEntity containing the
 * patient's information.
 * 
 * @param id The id parameter is a long value that represents the unique 
 * identifier of a patient.
 * @return The method is returning a ResponseEntity object with a generic
 *  type of PatientDTO.
 */
    @GetMapping({"/patients/findById/{id}"})
    public ResponseEntity<PatientDTO> findById(@PathVariable(name = "id") long id){
        return new ResponseEntity<>(patientService.getPatientById(id), HttpStatus.ACCEPTED);
    }

/**
 * This function updates a patient's information based on the provided patient DTO and ID.
 * 
 * @param p The parameter "p" is of type PatientDTO and is annotated 
 * with @RequestBody. This means that
 * it will be populated with the request body of the HTTP request.
 * @param id The "id" parameter is a path variable that represents the 
 * unique identifier of the patient
 * that needs to be updated.
 * @return The method is returning a ResponseEntity object with the updated Patient object.
 */
    @PutMapping({"/patients/update/{id}"})
    public ResponseEntity<Patient> update(@RequestBody PatientDTO p,
                                        @PathVariable(name = "id") long id){
        return ResponseEntity.ok(patientService.updatePatient(p,id));
    }

/**
 * This Java function deletes a patient with the specified ID and 
 * returns a response entity with a
 * success message.
 * 
 * @param id The id parameter is a long value that represents 
 * the unique identifier of the patient to
 * be deleted.
 * @return The method is returning a ResponseEntity object with 
 * a String message "DELETING PATIENT" and
 * an HTTP status code of OK (200).
 */
    @DeleteMapping({"/patients/delete/{id}"})
    public ResponseEntity<String> delete(@PathVariable(name = "id") long id){
        patientService.deletePatient(id);
        return new ResponseEntity<>("DELETING PATIENT",HttpStatus.OK);
    }


}
