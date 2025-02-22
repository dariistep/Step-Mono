package org.example.view;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.model.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

import java.util.Map;

@Component("profileView")
public class ProfileView implements View {
    @Override
    public String getContentType() {
        return "text/html";
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        User user = (User) model.get("user");
        response.setContentType(getContentType());
        response.getWriter().write(generateProfileHtml(user));
    }

    private String generateProfileHtml(User user) {
        StringBuilder html = new StringBuilder();
        html.append("<!DOCTYPE html>")
                .append("<html lang=\"en\">")
                .append("<head>")
                .append("    <meta charset=\"UTF-8\">")
                .append("    <title>Profile</title>")
                .append("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">")
                .append("</head>")
                .append("<body>")
                .append("    <div class=\"container my-5\">")
                .append("        <h1>Profile</h1>")
                .append("        <form action=\"/profile\" method=\"post\">")
                .append("            <div class=\"form-group\">")
                .append("                <label for=\"name\">Name</label>")
                .append("                <input type=\"text\" class=\"form-control\" id=\"name\" name=\"name\" value=\"").append(user.getName()).append("\" required>")
                .append("            </div>")
                .append("            <div class=\"form-group\">")
                .append("                <label for=\"identificationCode\">Identification Code</label>")
                .append("                <input type=\"text\" class=\"form-control\" id=\"identificationCode\" name=\"identificationCode\" value=\"").append(user.getIdentificationCode()).append("\" required>")
                .append("            </div>")
                .append("            <div class=\"form-group\">")
                .append("                <label for=\"passportData\">Passport Data</label>")
                .append("                <input type=\"text\" class=\"form-control\" id=\"passportData\" name=\"passportData\" value=\"").append(user.getPassportData()).append("\" required>")
                .append("            </div>")
                .append("            <button type=\"submit\" class=\"btn btn-primary\">Save</button>")
                .append("        </form>")
                .append("    </div>")
                .append("</body>")
                .append("</html>");

        return html.toString();
    }
}