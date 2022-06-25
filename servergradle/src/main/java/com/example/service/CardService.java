package com.example.service;


import com.example.entity.Card;
import com.example.entity.CardAnswer;
import com.example.entity.ContactingADoctor;
import com.example.models.*;
import com.example.repository.CardAnswerRepository;
import com.example.repository.CardRepository;
import com.example.repository.ContactingADoctorRepository;
import com.example.repository.DoctorRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class CardService {
    @Inject
    CardRepository cardRepository;
    @Inject
    DoctorRepository doctorRepository;
    @Inject
    CardAnswerRepository cardAnswerRepository;
    @Inject
    ContactingADoctorRepository contactingADoctorRepository;

    public List<CardModel> findAllByPatientId(Integer id) {
        List<Card> listCards = cardRepository.findAllByPatientId(id);
        List<CardModel> listCardModels = new ArrayList<>();
        for (Card card: listCards) {
            listCardModels.add(new CardModel(card.getId(), card.getName(),
                    card.getDoctor().getFIO(), card.getDoctor().getType(), card.getType()));
        }
        return listCardModels;
    }
    public List<DoctorCardModel> findAllByDoctorId(Integer id) {
        List<Card> listCards = cardRepository.findAllByDoctorId(id);
        List<DoctorCardModel> listCardModels = new ArrayList<>();
        for (Card card: listCards) {
            listCardModels.add(new DoctorCardModel(card.getId(), card.getName(),
                    card.getPatient().getFIO(), card.getType()));
        }
        return listCardModels;
    }

    public CardInfoModel getById(Integer id) {
        Card card = cardRepository.getById(id);
        CardInfoModel returnedCard = new CardInfoModel(card.getId(), card.getName(), card.getDoctor(), card.getPatient(), card.getType());
        return returnedCard;
    }

    public List<CardAnswerModel> getAllAnswer(Integer id) {
        List<CardAnswer> cardAnswers = cardAnswerRepository.findAllByCardIdOrderByAnswerDate(id);
        List<CardAnswerModel> cardAnswerModels = new ArrayList<>();
        for (CardAnswer cardAnswer: cardAnswers) {
            cardAnswerModels.add(new CardAnswerModel(cardAnswer.getId(), cardAnswer.getCard().getName(),
                    cardAnswer.getAnswer(), cardAnswer.getAnswerDate().toString(),
                    cardAnswer.getCard().getMinValue(), cardAnswer.getCard().getMaxValue()));
        }
        return cardAnswerModels;
    }
    public boolean newvalue(NewCardAnswerModel newCardAnswerModel) {
        try {
            CardAnswer cardAnswer = new CardAnswer(cardRepository.getById(newCardAnswerModel.getCardId()), newCardAnswerModel.getValue());
            cardAnswerRepository.save(cardAnswer);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean save(NewCardModel newCardModel) {
        ContactingADoctor contactingADoctor = contactingADoctorRepository.getById(newCardModel.getContactingId());
        try {
            cardRepository.save(new Card(newCardModel.getName(), contactingADoctor.getPatient(),
                    contactingADoctor.getDoctor(), newCardModel.getType(), newCardModel.getMin(), newCardModel.getMax()));
            contactingADoctorRepository.delete(contactingADoctor);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
