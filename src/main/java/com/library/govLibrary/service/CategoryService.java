package com.library.govLibrary.service;

import com.library.govLibrary.controller.dto.CategoryDto;
import com.library.govLibrary.exception.user.UserAccessForbidden;
import com.library.govLibrary.model.Category;
import com.library.govLibrary.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public Category addQuestionnaire(CategoryDto category) {
        Authentication principal = SecurityContextHolder.getContext().getAuthentication();
        if(principal.getAuthorities().stream().filter(grantedAuthority -> grantedAuthority.equals("ROLE_ADMIN")).count()<1)
            throw new UserAccessForbidden(principal.getName());

        Category addedCategory = new Category();
        addedCategory.setDescription(category.getDescription());
        addedCategory.setSummary(category.getSummary());
        return categoryRepository.save(addedCategory);
    }
}
