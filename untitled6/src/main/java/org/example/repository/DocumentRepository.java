package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.model.Document;
import org.example.model.User;

import java.util.List;

public interface DocumentRepository {
    Document save(Document document);

    List<Document> findByUser(User user);
    public static void persist(Document document) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(document);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        } finally {
            entityManager.close();
        }
    }

    public static TypedQuery<Document> createQuery(String query, Class<Document> documentClass) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        return entityManager.createQuery(query, documentClass);
    }
}
