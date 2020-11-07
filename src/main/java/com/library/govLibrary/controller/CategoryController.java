package com.library.govLibrary.controller;

import com.library.govLibrary.model.Category;
import com.library.govLibrary.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "${v1API}")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/categories")
    public List<Category> getAllQuestionnaire() {
        return categoryService.getCategories();
    }

    @PostMapping("/questionnaire")
    public Category addQuestionnaire(@RequestBody @Valid Category category){
        return categoryService.addQuestionnaire(category);
    }
}
