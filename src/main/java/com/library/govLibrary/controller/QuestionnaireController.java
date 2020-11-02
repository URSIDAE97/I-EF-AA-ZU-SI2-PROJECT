package com.library.govLibrary.controller;

import com.library.govLibrary.model.Questionnaire;
import com.library.govLibrary.service.QuestionnaireService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class QuestionnaireController {
    private final QuestionnaireService questionnaireService;

    @GetMapping("/questionnaire/{id}")
    public Questionnaire getQuestionnaireById(@PathVariable long id) {
        return questionnaireService.getQuestionnaireById(id);
    }

    @GetMapping("/questionnaires")
    public List<Questionnaire> getAllQuestionnaire(@RequestParam(required = false) Integer page) {
        int pageNum = page != null && page > 0 ? page : 1;
        return questionnaireService.getAllQuestionnaire(pageNum - 1);
    }

    @PostMapping("/questionnaire")
    public Questionnaire addQuestionnaire(@RequestBody Questionnaire questionnaire){
        return questionnaireService.addQuestionnaire(questionnaire);
    }
}
