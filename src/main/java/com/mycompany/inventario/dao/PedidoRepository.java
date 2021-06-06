/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.inventario.dao;

import com.mycompany.inventario.Entity.Pedido;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author wuser
 */
public class PedidoRepository extends GenericRepository<Long, Pedido> {

    public List<Pedido> getPedidoByStatus(Boolean isDone) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Pedido> criteria = builder.createQuery(Pedido.class);
        Root<Pedido> root = criteria.from(Pedido.class);
        criteria.select(root);
        criteria.where(builder.equal(root.get("isDone"), isDone));
        List<Pedido> result = entityManager.createQuery(criteria).getResultList();
        return result;
    }
}
