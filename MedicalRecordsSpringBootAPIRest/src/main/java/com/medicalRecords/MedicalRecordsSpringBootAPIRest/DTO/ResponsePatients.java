package com.medicalRecords.MedicalRecordsSpringBootAPIRest.DTO;



import java.util.List;

public class ResponsePatients {

    private List<PatientDTO> content;
    private int numberPages;
    private int measurePage;
    private long totalElements;
    private int totalPages;
    private boolean isLast;

    public ResponsePatients(){
        super();
    }

    public List<PatientDTO> getContent() {
        return content;
    }

    public void setContent(List<PatientDTO> content) {
        this.content = content;
    }

    public int getNumberPages() {
        return numberPages;
    }

    public void setNumberPages(int numberPages) {
        this.numberPages = numberPages;
    }

    public int getMeasurePage() {
        return measurePage;
    }

    public void setMeasurePage(int measurePage) {
        this.measurePage = measurePage;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public boolean isLast() {
        return isLast;
    }

    public void setLast(boolean isLast) {
        this.isLast = isLast;
    }
}
