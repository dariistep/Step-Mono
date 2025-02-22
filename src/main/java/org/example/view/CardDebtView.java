package org.example.view;

import jakarta.servlet.http.HttpServletResponse;
import org.example.model.Account;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

import java.util.List;
import java.util.Map;

@Component("cardView")
public class CardDebtView implements View {
    @Override
    public String getContentType() {
        return "text/html";
    }

    @Override
    public void render(Map<String, ?> model, jakarta.servlet.http.HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Account> accounts = (List<Account>) model.get("accounts");
        response.setContentType(getContentType());
        response.getWriter().write(generateCardHtml(accounts));

    }



    private String generateCardHtml(List<Account> accounts) {
        StringBuilder html = new StringBuilder();
        html.append("<html><head><title>Card Debt View</title></head><body>");
        html.append("<h1>Card Debt Overview</h1>");
        html.append("<table>");
        html.append("<tr><th>Account Number</th><th>Balance</th><th>Debt</th></tr>");

        for (Account account : accounts) {
            html.append("<tr>");
            html.append("<td>").append(account.getNumber()).append("</td>");
            html.append("<td>").append(account.getBalance()).append("</td>");
            html.append("<td>").append(account.getDebt()).append("</td>");
            html.append("</tr>");
        }

        html.append("</table>");
        html.append("</body></html>");
        return html.toString();
    }
}

