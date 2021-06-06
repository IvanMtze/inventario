/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.inventario.dao;
import com.mycompany.inventario.Entity.Item;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author wuser
 */
public class ItemRepository extends GenericRepository<Long, Item>{
        public Item findById(Long id){
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Item> criteria = builder.createQuery(Item.class);
        Root<Item> root = criteria.from(Item.class);
        criteria.select(root);
        criteria.where(builder.equal(root.get("id"), id));
        List<Item> result =entityManager.createQuery( criteria ).getResultList();
        return result.isEmpty()?null:result.get(0);
    }
}
