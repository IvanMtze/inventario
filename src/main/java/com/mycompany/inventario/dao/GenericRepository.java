/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.inventario.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Entity;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author wuser
 */
public abstract class GenericRepository<ID, ClassName> implements Repository<ID, ClassName> {

    EntityManager entityManager = Persistence.createEntityManagerFactory("org.mycompany.inventario.persistenceUnit").createEntityManager();

    public ClassName create(ClassName entity) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(entity);
        tx.commit();

        return entity;
    }

    public Boolean delete(ClassName entity) {
        entityManager.remove(entityManager.merge(entity));
        return true;
    }

    public ClassName find(ID id) {
        Class<ClassName> type = getEntityClass();
        return (ClassName) entityManager.find(type, id);
    }

    public ClassName update(ClassName t) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.merge(t);
        tx.commit();
        return t;
    }

    public Iterable<ClassName> findAll() {

        Class<ClassName> type = getEntityClass();

        CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<ClassName> criteriaQuery = cb.createQuery(type);
        Root<ClassName> root = criteriaQuery.from(type);
        criteriaQuery.select(root);
        TypedQuery<ClassName> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    public Boolean deleteById(ID id) {
        ClassName entityToDelete = find(id);
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.remove(entityManager.merge(entityToDelete));
        tx.commit();
        return true;
    }

    public Class<ClassName> getEntityClass() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        return (Class) pt.getActualTypeArguments()[1];
    }

    public Class<ClassName> getIdentifierClass() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        return (Class) pt.getActualTypeArguments()[0];
    }
}
