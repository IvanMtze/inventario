/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.inventario.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author wuser
 */
public interface Repository<ID, ClassName extends Object> {
    
    
    Boolean delete(ClassName entity);

    Boolean deleteById(ID id);

    ClassName find(final ID id);

    Iterable<ClassName> findAll();

    ClassName create(ClassName c);

    ClassName update(ClassName entity);
    
}
