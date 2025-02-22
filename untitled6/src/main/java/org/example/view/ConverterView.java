package org.example.view;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.model.Account;
import org.example.model.User;
import org.example.service.CurrencyConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

import java.util.List;
import java.util.Map;

@Component("homeView")
public class ConverterView implements View {
    private final CurrencyConverter currencyConverter;

    public ConverterView(CurrencyConverter currencyConverter) {
        this.currencyConverter = currencyConverter;
    }



    @Override
    public String getContentType() {
        return "text/html";
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        User user = (User) model.get("user");
        List<Account> accounts = (List<Account>) model.get("accounts");
        response.setContentType(getContentType());
        response.getWriter().write(generateHomeHtml(user, accounts));
    }

    private String generateHomeHtml(User user, List<Account> accounts) {
        StringBuilder html = new StringBuilder();
        html.append("<!DOCTYPE html>")
                .append("<html lang=\"en\">")
                .append("<head>")
                .append("    <meta charset=\"UTF-8\">")
                .append("    <title>Main Screen</title>")
                .append("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">")
                .append("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css\">")
                .append("    <style>")
                .append("        body {")
                .append("            background: linear-gradient(to bottom, #5ED4A4, #4B4BAF);")
                .append("            color: white;")
                .append("        }")
                .append("        .card {")
                .append("            background-color: rgba(255, 255, 255, 0.2);")
                .append("            border: none;")
                .append("        }")
                .append("        .card-title, .card-text {")
                .append("            color: white;")
                .append("        }")
                .append("        .card-icon {")
                .append("            font-size: 3rem;")
                .append("            cursor: pointer;")
                .append("        }")
                .append("    </style>")
                .append("</head>")
                .append("<body>")
                .append("    <div class=\"container my-5\">")
                .append("        <h1>Welcome, ").append(user.getName()).append("!</h1>")
                .append("        <div class=\"card\">")
                .append("            <div class=\"card-body d-flex justify-content-between align-items-center\">")
                .append("                <div>")
                .append("                    <h5 class=\"card-title\">Accounts</h5>")
                .append("                    <p class=\"card-text\">")
                .append("                        <strong>Total Balance:</strong> ").append(String.format("%.2f", getTotalBalance(accounts))).append(" ₴ (").append(String.format("%.2f", getTotalBalanceInEur(accounts))).append(" €)")
                .append("                    </p>")
                .append("                </div>")
                .append("                <a href=\"#\" onclick=\"openAccountsWindow(); return false;\" class=\"card-icon\">")
                .append("                    <i class=\"fas fa-credit-card\"></i>")
                .append("                </a>")
                .append("            </div>")
                .append("        </div>")
                .append("    </div>")
                .append("    <script>")
                .append("        function openAccountsWindow() {")
                .append("            window.open('/accounts', 'AccountsWindow', 'width=800,height=600');")
                .append("        }")
                .append("    </script>")
                .append("</body>")
                .append("</html>");

        return html.toString();
    }

    private double getTotalBalance(List<Account> accounts) {
        return accounts.stream()
                .mapToDouble(Account::getBalance)
                .sum();
    }

    private double getTotalBalanceInEur(List<Account> accounts) {
        double totalBalanceInUah = getTotalBalance(accounts);
        return currencyConverter.convertUahToEur(totalBalanceInUah);
    }
}
