package com.library.govLibrary.controller;

import com.library.govLibrary.controller.dto.QuestionnaireDto;
import com.library.govLibrary.controller.dto.QuestionnaireTitle;
import com.library.govLibrary.model.Questionnaire;
import com.library.govLibrary.service.QuestionnaireService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "${v1API}")
public class QuestionnaireController {
    private final QuestionnaireService questionnaireService;

    @GetMapping("/questionnaire/{id}")
    public Questionnaire getQuestionnaireById(@PathVariable long id) {
        return questionnaireService.getQuestionnaireById(id);
    }

    @GetMapping("/questionnaires/title")
    public List<QuestionnaireTitle> getQuestionnaireTitle() {
        return questionnaireService.getQuestionnairesTitle();
    }

    @GetMapping("/questionnaires")
    public List<Questionnaire> getAllQuestionnaire(@RequestParam(required = false) Integer page) {
        int pageNum = page != null && page > 0 ? page : 1;
        return questionnaireService.getAllQuestionnaire(pageNum - 1);
    }

    @PostMapping("/questionnaire")
    public Questionnaire addQuestionnaire(@RequestBody @Valid QuestionnaireDto questionnaire) {
        return questionnaireService.addQuestionnaire(questionnaire);
    }

    @DeleteMapping("/questionnaire/{id}")
    public void deleteQuestionnaireById(@PathVariable long id) {
        questionnaireService.deleteQuestionnaireById(id);
    }
}
