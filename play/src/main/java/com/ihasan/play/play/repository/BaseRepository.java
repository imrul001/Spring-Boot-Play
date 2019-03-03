package com.ihasan.play.play.repository;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.reflect.ParameterizedType;

/**
 * @author Imrul Hasan
 * @date 03/03/19
 */

public abstract class BaseRepository<T extends Object> {
    @Autowired
    @Qualifier(value = "sessionFactory")
    private SessionFactory sessionFactory;

    private Class<T> modelClass;

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    private Class<T> getModelClass() {
        if (modelClass == null) {
            ParameterizedType thisType = (ParameterizedType) getClass().getGenericSuperclass();
            this.modelClass = (Class<T>) thisType.getActualTypeArguments()[0];
        }
        return modelClass;
    }

    protected Criteria getCriteria() {
        return getSession().createCriteria(getModelClass());
    }

    public void create(T t) {
        getSession().save(t);
    }

    public void update(T t) {
        getSession().update(t);
    }

    public void delete(T t) {
        getSession().delete(t);
    }

}
