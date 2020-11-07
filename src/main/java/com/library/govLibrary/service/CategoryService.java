package com.library.govLibrary.service;

import com.library.govLibrary.model.Category;
import com.library.govLibrary.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public Category addQuestionnaire(Category category) {
        return categoryRepository.save(category);
    }
}
