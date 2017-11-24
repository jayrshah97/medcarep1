package com.medcare.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="prescription")
public class PrescriptionModel {
    @Id
    private int id;
    @Column(name = "date")
    private Date date;
    @Column(name = "note")
    private String note;
    @Column(name = "patient_id")
    private int patient_id;
    @Column(name = "doctor_id")
    private int doctor_id;

    @OneToMany(mappedBy = "pmObj")
    private List<PrescriptionMedicineModel> pmmList = new ArrayList<>();

    public List<PrescriptionMedicineModel> getPmmList() {
        return pmmList;
    }

    public void setPmmList(List<PrescriptionMedicineModel> pmmList) {
        this.pmmList = pmmList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public int getDoctor_id() {
        return doctor_id;
    }
}