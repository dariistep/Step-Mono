package org.example.repository;

import jakarta.persistence.EntityManager;
import org.example.model.Document;
import org.example.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transaction
public class DocumentRepositoryImpl implements DocumentRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Document> findByUser(User user) {
        return entityManager.createQuery("SELECT d FROM Document d WHERE d.user = :user", Document.class)
                .setParameter("user", user)
                .getResultList();
    }
    @Override
    public Document save(Document document) {
        entityManager.persist(document);
        return document;
    }
}
