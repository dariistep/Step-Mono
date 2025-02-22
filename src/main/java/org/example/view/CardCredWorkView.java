package org.example.view;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.model.Account;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

import java.util.Map;

@Component("accountDetailsView")
public class CardCredWorkView implements View {
    @Override
    public String getContentType() {
        return "text/html";
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Account account = (Account) model.get("account");
        response.setContentType(getContentType());
        response.getWriter().write(generateAccountDetailsHtml(account));
    }

    private String generateAccountDetailsHtml(Account account) {
        StringBuilder html = new StringBuilder();
        html.append("<!DOCTYPE html>")
                .append("<html lang=\"en\">")
                .append("<head>")
                .append("    <meta charset=\"UTF-8\">")
                .append("    <title>Account Details</title>")
                .append("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">")
                .append("</head>")
                .append("<body>")
                .append("    <div class=\"container my-5\">")
                .append("        <h1>Account Details</h1>")
                .append("        <div class=\"card\">")
                .append("            <div class=\"card-body\">")
                .append("                <h5 class=\"card-title\">Account Number: ").append(account.getNumber()).append("</h5>")
                .append("                <p class=\"card-text\">Account Type: ").append(account.getType()).append("</p>")
                .append("                <p class=\"card-text\">Balance: ").append(String.format("%.2f", account.getBalance())).append(" ₴</p>")
                .append("                <form action=\"/accounts/").append(account.getId()).append("/deposit\" method=\"post\">")
                .append("                    <div class=\"form-group\">")
                .append("                        <label for=\"depositAmount\">Deposit Amount</label>")
                .append("                        <input type=\"number\" class=\"form-control\" id=\"depositAmount\" name=\"amount\" step=\"0.01\" required>")
                .append("                    </div>")
                .append("                    <button type=\"submit\" class=\"btn btn-primary\">Deposit</button>")
                .append("                </form>")
                .append("                <form action=\"/accounts/").append(account.getId()).append("/withdraw\" method=\"post\">")
                .append("                    <div class=\"form-group\">")
                .append("                        <label for=\"withdrawAmount\">Withdraw Amount</label>")
                .append("                        <input type=\"number\" class=\"form-control\" id=\"withdrawAmount\" name=\"amount\" step=\"0.01\" required>")
                .append("                    </div>")
                .append("                    <button type=\"submit\" class=\"btn btn-danger\">Withdraw</button>")
                .append("                </form>")
                .append("            </div>")
                .append("        </div>")
                .append("    </div>")
                .append("</body>")
                .append("</html>");

        return html.toString();
    }
}
