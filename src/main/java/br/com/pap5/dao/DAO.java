package br.com.pap5.dao;

import javax.persistence.EntityManager;

public abstract class DAO<T>{
    protected EntityManager em;

    public DAO(EntityManager em) {
        this.em = em;
    }
}
