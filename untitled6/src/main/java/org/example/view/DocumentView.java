package org.example.view;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;
import org.example.model.Document;

//import javax.swing.text.Document;
import java.util.List;
import java.util.Map;

@Component("documentsView")
public class DocumentView implements View {
    @Override
    public String getContentType() {
        return "text/html";
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Document> documents = (List<Document>) model.get("documents");
        response.setContentType(getContentType());
        response.getWriter().write(generateDocumentsHtml(documents));
    }

    private String generateDocumentsHtml(List<Document> documents) {
        StringBuilder html = new StringBuilder();
        html.append("<!DOCTYPE html>")
                .append("<html lang=\"en\">")
                .append("<head>")
                .append("    <meta charset=\"UTF-8\">")
                .append("    <title>Documents</title>")
                .append("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">")
                .append("</head>")
                .append("<body>")
                .append("    <div class=\"container my-5\">")
                .append("        <h1>Documents</h1>")
                .append("        <form action=\"/documents\" method=\"post\" enctype=\"multipart/form-data\">")
                .append("            <div class=\"form-group\">")
                .append("                <label for=\"file\">Upload Document</label>")
                .append("                <input type=\"file\" class=\"form-control-file\" id=\"file\" name=\"file\" required>")
                .append("            </div>")
                .append("            <button type=\"submit\" class=\"btn btn-primary\">Upload</button>")
                .append("        </form>")
                .append("        <table class=\"table table-striped\">")
                .append("            <thead>")
                .append("                <tr>")
                .append("                    <th>File Name</th>")
                .append("                    <th>Upload Date</th>")
                .append("                    <th>Actions</th>")
                .append("                </tr>")
                .append("            </thead>")
                .append("            <tbody>");

        for (Document document : documents) {
            html.append("                <tr>")
                    .append("                    <td>").append(document.getFileName()).append("</td>")
                    .append("                    <td>").append(document.getUploadDate()).append("</td>")
                    .append("                    <td>")
                    .append("                        <a href=\"/documents/").append(document.getId()).append("\" class=\"btn btn-primary\">View</a>")
                    .append("                    </td>")
                    .append("                </tr>");
        }

        html.append("            </tbody>")
                .append("        </table>")
                .append("    </div>")
                .append("</body>")
                .append("</html>");

        return html.toString();
    }
}
