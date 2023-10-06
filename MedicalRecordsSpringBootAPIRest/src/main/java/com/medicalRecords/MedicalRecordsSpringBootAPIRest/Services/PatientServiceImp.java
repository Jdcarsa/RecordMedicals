package com.medicalRecords.MedicalRecordsSpringBootAPIRest.Services;

import com.medicalRecords.MedicalRecordsSpringBootAPIRest.DTO.PatientDTO;
import com.medicalRecords.MedicalRecordsSpringBootAPIRest.DTO.ResponsePatients;
import com.medicalRecords.MedicalRecordsSpringBootAPIRest.Exceptions.ResourceNotFoundException;
import com.medicalRecords.MedicalRecordsSpringBootAPIRest.Model.Patient;
import com.medicalRecords.MedicalRecordsSpringBootAPIRest.Repository.PatientRepository;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PatientServiceImp implements PatientService{

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PatientRepository repository;
    @Override
    public PatientDTO createPatient(PatientDTO patientDTO) {
        Patient p = new Patient(patientDTO.getNumId(),
                patientDTO.getName(),patientDTO.getLastName(),patientDTO.getSex()
                ,patientDTO.getBirthdate(),patientDTO.getAddress(),patientDTO.getPhone());

        Patient pSave = repository.save(p);

        PatientDTO pDTO =  new PatientDTO(pSave.getId(),p.getNumId(),
                pSave.getName(),pSave.getLastName(),patientDTO.getSex()
                ,pSave.getBirthdate(),pSave.getAddress(),pSave.getPhone());


        return pDTO;
    }

    @Override
    public ResponsePatients findAll(int pageNumber, int measurePage, String sortBy,String sortDir){
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())
                ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable =  PageRequest.of(pageNumber,measurePage, sort);
        Page<Patient> patients = repository.findAll(pageable);
        List<Patient> listPatients = patients.getContent();
        List<PatientDTO> content = listPatients.stream().
                map(publication -> modelMapper.map( publication, PatientDTO.class))
                .collect(Collectors.toList());
        ResponsePatients responsePatients = new ResponsePatients();
        responsePatients.setContent(content);
        responsePatients.setNumberPages(patients.getNumber());
        responsePatients.setMeasurePage(patients.getSize());
        responsePatients.setTotalElements(patients.getTotalElements());
        responsePatients.setTotalPages(patients.getTotalPages());
        responsePatients.setLast(patients.isLast());
        return responsePatients;
    }
    @Override
    public PatientDTO getPatientById(Long patientId) {
        Patient p = this.repository.findById(patientId).
                orElseThrow(()-> new ResourceNotFoundException("Patient","id",patientId));

        return modelMapper.map(p,PatientDTO.class);
    }

    @Override
    public Patient updatePatient(PatientDTO patientDTO,Long patientId) {
        Patient p = this.repository.findById(patientId).
                orElseThrow(()-> new ResourceNotFoundException("Patient","id",patientId));
        p.setName(patientDTO.getName());
        p.setLastName(patientDTO.getLastName());
        p.setNumId(patientDTO.getNumId());
        p.setBirthdate(patientDTO.getBirthdate());
        p.setSex(patientDTO.getSex());
        p.setAddress(patientDTO.getAddress());
        p.setPhone(patientDTO.getPhone());
        return repository.save(p);

    }

    @Override
    public void deletePatient(Long patientId) {
        Patient p = this.repository.findById(patientId).
                orElseThrow(()-> new ResourceNotFoundException("Patient","id",patientId));

        repository.delete(p);
    }
}
