package com.brs.project.category.dao;

import com.brs.project.category.entity.Category;
import com.sytan.base.lib.ApplicationException;

import java.util.List;

public interface CategoryDAO {
    void addCategory(Category category) throws ApplicationException;
    Category getCategory(String id) throws ApplicationException;
    List<Category> getCategoryList(String typ) throws ApplicationException;
}
