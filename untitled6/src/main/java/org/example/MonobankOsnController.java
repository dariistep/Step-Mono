/*package com.example.controller;

import com.example.Model.MonobankOsnModel;
import com.example.view.MonobankOsnView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MonobankOsnController {
    private final MonobankOsnModel monobankOsnModel;
    private final MonobankOsnView monobankOsnView;

    @Autowired
    public MonobankOsnController(MonobankOsnModel monobankOsnModel, MonobankOsnView monobankOsnView) {
        this.monobankOsnModel = monobankOsnModel;
        this.monobankOsnView = monobankOsnView;
    }

    @GetMapping("/app")
    public String showAppPage(Model model) {
        model.addAttribute("balance", monobankOsnModel.getBalance());
        model.addAttribute("plannedPayments", monobankOsnModel.getPlannedPayments());
        return "app";
    }
}*/