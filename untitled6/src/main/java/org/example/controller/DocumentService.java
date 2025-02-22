package org.example.controller;
import org.example.model.Document;
import org.example.model.User;
import org.example.repository.DocumentRepository;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;
public class DocumentService {
    private final DocumentRepository documentRepository;

    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public List<Document> getDocumentsByUser(User user) {
        return documentRepository.findByUser(user);
    }

    public Document saveDocument(User user, MultipartFile file) {
        try {
            Document document = new Document();
            document.setUser(user);
            document.setName(file.getOriginalFilename());
            document.setContent(file.getBytes());
            return documentRepository.save(document);
        } catch (IOException e) {
            throw new RuntimeException("Error saving document", e);
        }
    }

}
