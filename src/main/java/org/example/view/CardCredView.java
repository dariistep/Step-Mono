package org.example.view;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.model.Account;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

import java.util.Map;

@Component("accountFormView")
public class CardCredView implements View {
    @Override
    public String getContentType() {
        return "text/html";
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Account account = (Account) model.get("account");
        response.setContentType(getContentType());
        response.getWriter().write(generateAccountFormHtml(account));
    }

    private String generateAccountFormHtml(Account account) {
        StringBuilder html = new StringBuilder();
        html.append("<!DOCTYPE html>")
                .append("<html lang=\"en\">")
                .append("<head>")
                .append("    <meta charset=\"UTF-8\">")
                .append("    <title>Add Account</title>")
                .append("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">")
                .append("</head>")
                .append("<body>")
                .append("    <div class=\"container my-5\">")
                .append("        <h1>Add Account</h1>")
                .append("        <form action=\"/accounts\" method=\"post\">")
                .append("            <div class=\"form-group\">")
                .append("                <label for=\"number\">Account Number</label>")
                .append("                <input type=\"text\" class=\"form-control\" id=\"number\" name=\"number\" value=\"").append(account.getNumber()).append("\" required>")
                .append("            </div>")
                .append("            <div class=\"form-group\">")
                .append("                <label for=\"type\">Account Type</label>")
                .append("                <input type=\"text\" class=\"form-control\" id=\"type\" name=\"type\" value=\"").append(account.getType()).append("\" required>")
                .append("            </div>")
                .append("            <button type=\"submit\" class=\"btn btn-primary\">Create Account</button>")
                .append("        </form>")
                .append("    </div>")
                .append("</body>")
                .append("</html>");

        return html.toString();
    }
}
