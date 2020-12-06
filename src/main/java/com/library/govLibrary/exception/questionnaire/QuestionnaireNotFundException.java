package com.library.govLibrary.exception.questionnaire;

public class QuestionnaireNotFundException extends RuntimeException {
    public QuestionnaireNotFundException (long id) {
        super("Questionnaire with id: " + id + " not found");
    }
}
