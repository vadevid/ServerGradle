package com.example.dto;

import java.io.Serializable;
import java.util.Objects;

public class CardAnswerDto implements Serializable {
    private final Integer id;
    private final CardDto card;
    private final Integer answer;

    public CardAnswerDto(Integer id, CardDto card, Integer answer) {
        this.id = id;
        this.card = card;
        this.answer = answer;
    }

    public Integer getId() {
        return id;
    }

    public CardDto getCard() {
        return card;
    }

    public Integer getAnswer() {
        return answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardAnswerDto entity = (CardAnswerDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.card, entity.card) &&
                Objects.equals(this.answer, entity.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, card, answer);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "card = " + card + ", " +
                "answer = " + answer + ")";
    }
}
