package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerProvider {
    private static final String PERSISTENCE_UNIT_NAME = "monobank-pu";
    private static EntityManagerFactory entityManagerFactory;

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    private EntityManagerProvider() {
        // Private constructor to prevent instantiation
    }
}

