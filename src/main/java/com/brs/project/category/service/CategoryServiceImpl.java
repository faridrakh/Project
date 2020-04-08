package com.brs.project.category.service;

import com.brs.project.category.dao.CategoryDAO;
import com.brs.project.category.entity.Category;
import com.sytan.base.lib.ApplicationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryDAO categoryDAO;

    public CategoryServiceImpl(CategoryDAO categoryDAO){
        this.categoryDAO = categoryDAO;
    }

    @Override
    public void addCategory(Category category) throws ApplicationException {
        categoryDAO.addCategory(category);
    }

    @Override
    public Category getCategory(String id) throws ApplicationException {
        return categoryDAO.getCategory(id);
    }

    @Override
    public List<Category> getCategoryList(String typ) throws ApplicationException {
        return categoryDAO.getCategoryList(typ);
    }
}
