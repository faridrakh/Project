package com.brs.project.category.dao;

import com.brs.project.category.entity.Category;
import com.sytan.base.lib.ApplicationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class CategoryDAOImpl implements CategoryDAO {
    private static final Logger logger = LogManager.getLogger(CategoryDAOImpl.class);
    private EntityManager entityManager;

    public CategoryDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void addCategory(Category category) throws ApplicationException {
        entityManager.persist(category);
    }

    @Override
    public Category getCategory(String id) throws ApplicationException {
        Category result;
        String qr = "FROM Category u WHERE u.id = :id";
        Query query = entityManager.createQuery(qr);
        query.setParameter("id", id);
        result = (Category) query.getSingleResult();
        return result;
    }

    @Override
    public List<Category> getCategoryList(String typ) throws ApplicationException {
        String qr = "FROM Category u where u.type = :typ";
        Query query = entityManager.createQuery(qr);
        query.setParameter("typ", typ);
        return query.getResultList();
    }
}
