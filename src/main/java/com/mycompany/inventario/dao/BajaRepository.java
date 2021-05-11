/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.inventario.dao;
import com.mycompany.inventario.Entity.Baja;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Criteria;

/**
 *
 * @author wuser
 */
public class BajaRepository extends GenericRepository<Long, Baja>{
    
    public List<Baja> getBajasByDate(Date date){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Baja> cq = cb.createQuery(Baja.class);
        
    }
}