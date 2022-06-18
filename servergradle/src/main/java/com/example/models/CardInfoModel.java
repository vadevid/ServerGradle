package com.example.models;

import com.example.entity.Doctor;
import io.micronaut.core.annotation.Introspected;

@Introspected
public class CardInfoModel {
    Integer id;
    String name;
    Doctor doctor;
    String cardType;

    public CardInfoModel(Integer id, String name, Doctor doctor, String cardType) {
        this.id = id;
        this.name = name;
        this.doctor = doctor;
        this.cardType = cardType;
    }

    public CardInfoModel() {
    }
}
