package com.library.govLibrary.service;

import com.library.govLibrary.controller.dto.QuestionnaireDto;
import com.library.govLibrary.exception.user.UserAccessForbidden;
import com.library.govLibrary.model.Questionnaire;
import com.library.govLibrary.repository.QuestionRepository;
import com.library.govLibrary.repository.QuestionnaireRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionnaireService {
    private static final int SIZE = 20;
    private static final Sort.Direction DIRECTION = Sort.Direction.ASC;
    private final QuestionnaireRepository questionnaireRepository;
    private final QuestionRepository questionRepository;

    public List<Questionnaire> getAllQuestionnaire(int page){
        return questionnaireRepository.findAllQuestionnaire(PageRequest.of(page, SIZE, DIRECTION, "idCategory", "expired"));
    }

    public Questionnaire getQuestionnaireById(long id){
        return questionnaireRepository.findById(id).orElseThrow();
    }

    @Transactional
    public Questionnaire addQuestionnaire(QuestionnaireDto questionnaire) {
        Authentication principal = SecurityContextHolder.getContext().getAuthentication();
        if(principal.getAuthorities().stream().filter(grantedAuthority -> grantedAuthority.equals("ROLE_ADMIN")).count()<1)
            throw new UserAccessForbidden(principal.getName());

        Questionnaire addedQuestionnaire = new Questionnaire();
        addedQuestionnaire.setActivation(questionnaire.getActivation());
        addedQuestionnaire.setCreated(LocalDateTime.now());
        addedQuestionnaire.setDescription(questionnaire.getDescription());
        addedQuestionnaire.setExpired(questionnaire.getExpired());
        addedQuestionnaire.setIdCategory(questionnaire.getIdCategory());
        addedQuestionnaire.setTitle(questionnaire.getTitle());

        addedQuestionnaire.setUsername(principal.getName());
        addedQuestionnaire.setQuestion(questionnaire.getQuestion());

        Questionnaire save = questionnaireRepository.save(addedQuestionnaire);

        questionnaire.getQuestion().forEach(question -> question.setQuestionnaireId(save.getId()));
        questionRepository.saveAll(questionnaire.getQuestion());
        return save;
    }

    public void deleteQuestionnaireById(long id) {
        Authentication principal = SecurityContextHolder.getContext().getAuthentication();
        if(principal.getAuthorities().stream().filter(grantedAuthority -> grantedAuthority.equals("ROLE_ADMIN")).count()<1)
            throw new UserAccessForbidden(principal.getName());

        questionRepository.deleteById(id);
    }
}
