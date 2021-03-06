/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.inventario.dao;
import com.mycompany.inventario.Entity.Baja;
import java.util.Date;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


/**
 *
 * @author wuser
 */
public class BajaRepository extends GenericRepository<Long, Baja>{
    
    public List<Baja> getBajasByDate(Date date){
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Baja> criteria = builder.createQuery(Baja.class);
        Root<Baja> root = criteria.from(Baja.class);
        criteria.select(root);
        criteria.where(builder.equal(root.get("date"), date));
        return entityManager.createQuery( criteria ).getResultList();
    }
}