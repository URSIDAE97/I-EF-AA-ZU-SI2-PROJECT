package com.library.govLibrary.exception.category;

public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(long id) {
        super("Category with id: " + id + " not found");
    }
}
