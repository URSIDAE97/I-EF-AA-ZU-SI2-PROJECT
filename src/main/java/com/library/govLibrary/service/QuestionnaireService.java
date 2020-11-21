package com.library.govLibrary.service;

import com.library.govLibrary.controller.dto.QuestionnaireDto;
import com.library.govLibrary.controller.dto.QuestionnaireTitle;
import com.library.govLibrary.exception.user.UserAccessForbidden;
import com.library.govLibrary.model.Option;
import com.library.govLibrary.model.Question;
import com.library.govLibrary.model.Questionnaire;
import com.library.govLibrary.repository.CategoryRepository;
import com.library.govLibrary.repository.OptionRepository;
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
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionnaireService {
    private static final int SIZE = 20;
    private static final Sort.Direction DIRECTION = Sort.Direction.ASC;
    private final QuestionnaireRepository questionnaireRepository;
    private final QuestionRepository questionRepository;
    private final OptionRepository optionRepository;
    private final CategoryRepository categoryRepository;

    public List<Questionnaire> getAllQuestionnaire(int page) {
        return questionnaireRepository.findAllQuestionnaire(PageRequest.of(page, SIZE, DIRECTION, "idCategory", "expired"));
    }

    public Questionnaire getQuestionnaireById(long id) {
        return questionnaireRepository.findById(id).orElseThrow();
    }

    @Transactional
    public Questionnaire addQuestionnaire(QuestionnaireDto questionnaire) {
        Authentication principal = SecurityContextHolder.getContext().getAuthentication();
        if (principal.getAuthorities().stream().noneMatch(grantedAuthority -> grantedAuthority.toString().equals("ROLE_ADMIN")))
            throw new UserAccessForbidden(principal.getName());

        categoryRepository.findById(questionnaire.getIdCategory()).orElseThrow();

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
        List<Question> questions = questionRepository.saveAll(questionnaire.getQuestion());

        questions.forEach(question -> question.getOption().forEach(option -> option.setQuestionId(question.getId())));
        List<Option> options = questions.stream().map(Question::getOption).flatMap(Collection::stream).collect(Collectors.toList());

        optionRepository.saveAll(options);

        return save;
    }

    public void deleteQuestionnaireById(long id) {
        Authentication principal = SecurityContextHolder.getContext().getAuthentication();
        if (principal.getAuthorities().stream().filter(grantedAuthority -> grantedAuthority.equals("ROLE_ADMIN")).count() < 1)
            throw new UserAccessForbidden(principal.getName());

        questionRepository.deleteById(id);
    }

    public List<QuestionnaireTitle> getQuestionnairesTitle() {
        List<Questionnaire> questionnaireList = questionnaireRepository.findAll(Sort.by(Sort.Direction.ASC, "expired"));
        return questionnaireList.stream().map(
                questionnaire -> QuestionnaireTitle.builder()
                        .id(questionnaire.getId()).title(questionnaire.getTitle())
                        .build())
                .collect(Collectors.toList());
    }
}
