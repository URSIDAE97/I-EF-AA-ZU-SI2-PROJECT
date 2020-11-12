package com.library.govLibrary.controller;

import com.library.govLibrary.controller.dto.CategoryDto;
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
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }

    @PostMapping("/category")
    public Category addCategory(@RequestBody @Valid CategoryDto category){
        return categoryService.addCategory(category);
    }

    @DeleteMapping("/category/{id}")
    public void deleteCategory(@PathVariable long id){
        categoryService.deleteCategory(id);
    }
}
