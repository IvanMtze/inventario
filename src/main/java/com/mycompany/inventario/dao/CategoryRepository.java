/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.inventario.dao;
import com.mycompany.inventario.Entity.Category;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author wuser
 */
public class CategoryRepository extends GenericRepository<Long, Category>{
    public Category findByName(String name){
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Category> criteria = builder.createQuery(Category.class);
        Root<Category> root = criteria.from(Category.class);
        criteria.select(root);
        criteria.where(builder.equal(root.get("nombre"), name));
        List<Category> result =entityManager.createQuery( criteria ).getResultList();
        return result.isEmpty()?null:result.get(0);
    }
}
