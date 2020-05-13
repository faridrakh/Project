package com.brs.project.category.service;

import com.brs.project.category.dao.CategoryDAO;
import com.brs.project.category.entity.Category;
import com.brs.project.common.helper.CommonUtils;
import com.sytan.base.lib.ApplicationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    private CategoryDAO categoryDAO;
    private final CommonUtils commonUtils  = new CommonUtils();

    public CategoryServiceImpl(CategoryDAO categoryDAO){
        this.categoryDAO = categoryDAO;
    }

    @Override
    public void addCategory(Category category) throws ApplicationException {
        category.setId(commonUtils.generateUUID());
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
