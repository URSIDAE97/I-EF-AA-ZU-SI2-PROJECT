package com.library.govLibrary.controller.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CategoryDto {
    @NotNull
    @NotBlank
    @Length(min = 5, max = 80)
    private String summary;
    @NotNull
    @NotBlank
    @Length(min = 5, max = 500)
    private String description;
}
