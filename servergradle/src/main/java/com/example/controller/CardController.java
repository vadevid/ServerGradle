package com.example.controller;

import com.example.entity.Card;
import com.example.entity.Patient;
import com.example.models.CardAnswerModel;
import com.example.models.CardInfoModel;
import com.example.models.CardModel;
import com.example.repository.CardRepository;
import com.example.repository.DoctorRepository;
import com.example.service.CardService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import jakarta.inject.Inject;

import javax.validation.Valid;
import java.util.List;

@Controller("/card")
@Secured(SecurityRule.IS_ANONYMOUS)
public class CardController {
    @Inject
    CardRepository cardRepository;
    @Inject
    DoctorRepository doctorRepository;
    @Inject
    CardService cardService;

    @Post(value = "/getall", consumes = MediaType.APPLICATION_JSON)
    public List<CardModel> findAllByPatientId(@Body @Valid Patient patient) {
        return cardService.findAllByPatientId(patient.getId());
    }
    @Post(value = "/getcard", consumes = MediaType.APPLICATION_JSON)
    public CardInfoModel getById(@Body @Valid Card card) {
        return cardService.getById(card.getId());
    }

    @Post(value = "/getallanswer", consumes = MediaType.APPLICATION_JSON)
    public List<CardAnswerModel> getAllAnswer(@Body Card card) { return cardService.getAllAnswer(card.getId()); }
}
