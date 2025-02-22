package org.example.service;

import org.springframework.stereotype.Service;

@Service
public class CurrencyConverter {
    private static final double EUR_TO_UAH_RATE = 32.5;

    public double convertUahToEur(double uahAmount) {
        return uahAmount / EUR_TO_UAH_RATE;
    }
}
