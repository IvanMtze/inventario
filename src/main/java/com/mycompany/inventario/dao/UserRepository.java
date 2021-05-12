/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.inventario.dao;

import com.mycompany.inventario.Entity.Baja;
import com.mycompany.inventario.Entity.User;
import java.util.Date;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author wuser
 */
public class UserRepository extends GenericRepository<Long, User>{
        public User validateUser(String username, String password){
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        Root<User> root = criteria.from(User.class);
        criteria.select(root);
        criteria.where(builder.equal(root.get("username"), username),
                builder.equal(root.get("password"), password));
        List<User> result =entityManager.createQuery( criteria ).getResultList();
        return result.isEmpty()?null:result.get(0);
    }
}