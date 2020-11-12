package com.library.govLibrary.controller.dto;

import com.library.govLibrary.model.Question;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class QuestionnaireDto {
    @Min(0)
    private long idCategory;

    @NotBlank
    @NotNull
    @Length(min = 5, max = 80)
    private String title;

    @NotBlank
    @NotNull
    @Length(min = 5, max = 500)
    private String description;

    private LocalDateTime activation;
    private LocalDateTime expired;

    @NotEmpty
    private List<Question> question;
}
