package com.library.govLibrary.controller.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
public class QuestionnaireDto {
    @NotEmpty
    private long idCategory;
    @NotBlank
    @NotNull
    private String title;
    @NotBlank
    @NotNull
    private String description;
    private LocalDateTime activation;
    private LocalDateTime expired;
}
