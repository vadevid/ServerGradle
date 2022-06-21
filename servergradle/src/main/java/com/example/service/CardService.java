package com.example.service;


import com.example.entity.Card;
import com.example.entity.CardAnswer;
import com.example.models.CardAnswerModel;
import com.example.models.CardInfoModel;
import com.example.models.CardModel;
import com.example.repository.CardAnswerRepository;
import com.example.repository.CardRepository;
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

    public List<CardModel> findAllByPatientId(Integer id) {
        List<Card> listCards = cardRepository.findAllByPatientId(id);
        List<CardModel> listCardModels = new ArrayList<>();
        for (Card card: listCards) {
            listCardModels.add(new CardModel(card.getId(), card.getName(),
                    card.getDoctor().getFIO(), card.getDoctor().getType(), card.getType()));
        }
        return listCardModels;
    }

    public CardInfoModel getById(Integer id) {
        Card card = cardRepository.getById(id);
        CardInfoModel returnedCard = new CardInfoModel(card.getId(), card.getName(), card.getDoctor(), card.getType());
        return returnedCard;
    }

    public List<CardAnswerModel> getAllAnswer(Integer id) {
        List<CardAnswer> cardAnswers = cardAnswerRepository.findAllByCardIdOrderByAnswerDate(id);
        List<CardAnswerModel> cardAnswerModels = new ArrayList<>();
        for (CardAnswer cardAnswer: cardAnswers) {
            cardAnswerModels.add(new CardAnswerModel(cardAnswer.getId(), cardAnswer.getCard().getName(),
                    cardAnswer.getAnswer(), cardAnswer.getAnswerDate().toString()));
        }
        return cardAnswerModels;
    }
}
