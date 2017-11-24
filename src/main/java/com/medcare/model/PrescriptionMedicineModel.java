package com.medcare.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="prescription_medicine")
public class PrescriptionMedicineModel {
    @Id
    private int id;
    @Column(name="medicine_id")
    private int medicine_id;

    @ManyToOne
    @JoinColumn(name="prescription_id")
    PrescriptionModel pmObj;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getMedicine_id() {
        return medicine_id;
    }
    public void setMedicine_id(int medicine_id) {
        this.medicine_id = medicine_id;
    }
}