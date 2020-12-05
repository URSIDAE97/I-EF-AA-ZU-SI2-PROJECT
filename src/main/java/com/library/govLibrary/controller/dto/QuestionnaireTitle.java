package com.library.govLibrary.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class QuestionnaireTitle {
    private long id;
    private String title;
}
