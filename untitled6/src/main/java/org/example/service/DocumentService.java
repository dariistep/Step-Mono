package org.example.service;

import org.example.model.Document;
import org.example.model.User;
import org.example.repository.DocumentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class DocumentService {
    private final DocumentRepository documentRepository;

    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public List<Document> getDocumentsByUser(User user) {
        return documentRepository.findByUser(user);
    }

    public Document saveDocument(User user, MultipartFile file) {
        Document document = new Document();
        document.setFileName(file.getOriginalFilename());
        document.setContentType(file.getContentType());
        try {
            document.setContent(file.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Error saving document content", e);
        }
        document.setUser(user);
        document.setUploadDate(new Date());
        return documentRepository.save(document);
    }
}

/*package org.example.service;

import org.example.model.User;
import org.example.repository.DocumentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.*;
import java.util.Date;
import java.util.List;

@Service
public class DocumentService {
    private final DocumentRepository documentRepository;

    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public List<org.example.model.Document> getDocumentsByUser(User user) {
        return documentRepository.findByUser(user);
    }

    public Document saveDocument(User user, MultipartFile file) {
        Document document = new Document() {
            @Override
            public int getLength() {
                return 0;
            }

            @Override
            public void addDocumentListener(DocumentListener listener) {

            }

            @Override
            public void removeDocumentListener(DocumentListener listener) {

            }

            @Override
            public void addUndoableEditListener(UndoableEditListener listener) {

            }

            @Override
            public void removeUndoableEditListener(UndoableEditListener listener) {

            }

            @Override
            public Object getProperty(Object key) {
                return null;
            }

            @Override
            public void putProperty(Object key, Object value) {

            }

            @Override
            public void remove(int offs, int len) throws BadLocationException {

            }

            @Override
            public void insertString(int offset, String str, AttributeSet a) throws BadLocationException {

            }

            @Override
            public String getText(int offset, int length) throws BadLocationException {
                return null;
            }

            @Override
            public void getText(int offset, int length, Segment txt) throws BadLocationException {

            }

            @Override
            public Position getStartPosition() {
                return null;
            }

            @Override
            public Position getEndPosition() {
                return null;
            }

            @Override
            public Position createPosition(int offs) throws BadLocationException {
                return null;
            }

            @Override
            public Element[] getRootElements() {
                return new Element[0];
            }

            @Override
            public Element getDefaultRootElement() {
                return null;
            }

            @Override
            public void render(Runnable r) {

            }
        };
        document.setFileName(file.getOriginalFilename());
        document.setContentType(file.getContentType());
        document.setContent(file.getBytes());
        document.setUser(user);
        document.setUploadDate(new Date());
        return documentRepository.save(document);
    }
}
*/