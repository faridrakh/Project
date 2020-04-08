package com.brs.project.category.service;

import com.brs.project.category.entity.Category;
import com.sytan.base.lib.ApplicationException;

import java.util.List;

public interface CategoryService {
    void addCategory(Category category) throws ApplicationException;
    Category getCategory(String id) throws ApplicationException;
    List<Category> getCategoryList(String typ) throws ApplicationException;
}
