package com.library.govLibrary.service;

import com.library.govLibrary.model.Questionnaire;
import com.library.govLibrary.repository.QuestionnaireRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionnaireService {
    private static final int SIZE = 20;
    private static final Sort.Direction DIRECTION = Sort.Direction.ASC;
    private final QuestionnaireRepository questionnaireRepository;

    public List<Questionnaire> getAllQuestionnaire(int page){
        return questionnaireRepository.findAllQuestionnaire(PageRequest.of(page, SIZE, DIRECTION, "idCategory", "expired"));
    }

    public Questionnaire getQuestionnaireById(long id){
        return questionnaireRepository.findById(id).orElseThrow();
    }
}
