package com.library.govLibrary.service;

import com.library.govLibrary.controller.dto.CategoryDto;
import com.library.govLibrary.exception.category.CategoryNotFoundException;
import com.library.govLibrary.exception.user.UserAccessForbidden;
import com.library.govLibrary.model.Category;
import com.library.govLibrary.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public Category addCategory(CategoryDto category) {
        Authentication principal = SecurityContextHolder.getContext().getAuthentication();
        if(principal.getAuthorities().stream().noneMatch(grantedAuthority -> grantedAuthority.toString().equals("ROLE_ADMIN")))
            throw new UserAccessForbidden(principal.getName());

        Category addedCategory = new Category();
        addedCategory.setDescription(category.getDescription());
        addedCategory.setSummary(category.getSummary());
        return categoryRepository.save(addedCategory);
    }

    public Category editCategory(long id, CategoryDto category) {
        Authentication principal = SecurityContextHolder.getContext().getAuthentication();
        if(principal.getAuthorities().stream().noneMatch(grantedAuthority -> grantedAuthority.toString().equals("ROLE_ADMIN")))
            throw new UserAccessForbidden(principal.getName());

        Optional<Category> optCategory = categoryRepository.findById(id);
        if (optCategory.isPresent()) {
            Category existingCategory = optCategory.get();
            existingCategory.setDescription(category.getDescription());
            existingCategory.setSummary(category.getSummary());
            return categoryRepository.save(existingCategory);
        } else {
            throw new CategoryNotFoundException(id);
        }
    }

    public void deleteCategory(long id) {
        Authentication principal = SecurityContextHolder.getContext().getAuthentication();
        if(principal.getAuthorities().stream().noneMatch(grantedAuthority -> grantedAuthority.toString().equals("ROLE_ADMIN")))
            throw new UserAccessForbidden(principal.getName());

        categoryRepository.deleteById(id);
    }
}
