package org.example.view;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.model.TransactionDebt;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Component("transactionDebtView")
public class TransactionDebtView implements View {

    @Override
    public String getContentType() {
        return "text/html";
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<TransactionDebt> transactions = (List<TransactionDebt>) model.get("transactions");
        response.setContentType(getContentType());
        response.getWriter().write(generateTransactionDebtHtml(transactions));
    }

    private String generateTransactionDebtHtml(List<TransactionDebt> transactions) {
        StringBuilder html = new StringBuilder();
        html.append("<html><head><title>Transaction Debt View</title></head><body>");
        html.append("<h1>Transaction Debt Overview</h1>");
        html.append("<table>");
        html.append("<tr><th>ID</th><th>From Account</th><th>To Account</th><th>Date</th><th>Debt</th></tr>");

        for (TransactionDebt transaction : transactions) {
            html.append("<tr>");
            html.append("<td>").append(transaction.getId()).append("</td>");
            html.append("<td>").append(transaction.getFromRakhunok()).append("</td>");
            html.append("<td>").append(transaction.getToRakhunok()).append("</td>");
            html.append("<td>").append(transaction.getDatetransaction()).append("</td>");
            html.append("<td>").append(transaction.getSumaDebt()).append("</td>");
            html.append("</tr>");
        }

        html.append("</table>");
        html.append("</body></html>");
        return html.toString();
    }
}