package com.library.govLibrary.controller.dto;

import com.library.govLibrary.model.Question;
import lombok.Getter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Getter
public class QuestionnaireDto {
    @Min(0)
    private long idCategory;
    @NotBlank
    @NotNull
    private String title;
    @NotBlank
    @NotNull
    private String description;
    private LocalDateTime activation;
    private LocalDateTime expired;
    @NotEmpty
    private List<Question> question;
}
