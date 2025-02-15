package com.day.hibernatetest.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import lombok.Setter;
import lombok.Getter;

@Setter
@Getter
public class HibernateConfig {

    private EntityManagerFactory factory;
    private EntityManager entityManager;

    public HibernateConfig() {
        this.setFactory(Persistence.createEntityManagerFactory("hibernate_test_pu"));
    }

    public EntityManager getEntityManager() {
        return entityManager = new HibernateConfig().getFactory().createEntityManager();
    }

    public void closeConnection() {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
            getFactory().close();
        }
    }

}
