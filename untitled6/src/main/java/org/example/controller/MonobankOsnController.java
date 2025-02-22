package org.example.controller;

import jakarta.servlet.http.HttpSession;
import org.example.model.Account;
import org.example.model.User;
import org.example.service.AccountCredService;
import org.example.service.AccountDebtService;
import org.example.service.CurrencyConverter;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.text.Document;
import java.util.List;

@Controller
@RequestMapping("/home")
public class MonobankOsnController {
    private final UserService userService;
    private final DocumentService documentService;
    private final AccountDebtService accountDebtService;
    private final AccountCredService accountCredService;
    private final CurrencyConverter currencyConverter;
    //private final Object TransactionService;

    @Autowired
    public MonobankOsnController (UserService userService, DocumentService documentService, AccountDebtService accountDebtService, AccountCredService accountCredService, CurrencyConverter currencyConverter) {
        this.userService = userService;
        this.documentService = documentService;
        this.accountDebtService = accountDebtService;
        this.accountCredService = accountCredService;
        this.currencyConverter = currencyConverter;

    }

    @GetMapping("/")//для БД.
    public String home(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            model.addAttribute("user", user);

        }
        return "home";
    }

    @GetMapping("/")
    public String getHomePage(Model model) {
        User currentUser = userService.getCurrentUser();
        User user = userService.getCurrentUser();
        List<Account> accounts = accountCredService.getAccountsByUser(user);
        model.addAttribute("user", user);
        model.addAttribute("accounts", accounts);
        model.addAttribute("user", currentUser);
        return "home";
    }

    @GetMapping("/accounts/new")
    public String newAccount(Model model) {
        model.addAttribute("account", new Account());
        return "account-form";
    }

    @PostMapping("/accounts")
    public String createCredAccount(@ModelAttribute Account account, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "account-form";
        }
        User user = userService.getCurrentUser();
        account.setUser(user);
        account.setBalance(15000.0);
        accountCredService.saveAccount(account);
        return "redirect:/";
    }

    @PostMapping("/register")
    public String register(@RequestParam String name, @RequestParam String surname,
                           @RequestParam String email, @RequestParam String password) {
        User user = userService.register(name, surname, email, password);
        AccountService accountService = new AccountService();
        Account defaultAccount = accountService.createDefaultAccount(user);
        //створити об'єкт
        return "redirect:/";
    }

    @GetMapping("/accounts/{id}")
    public String accountCredDetails(@PathVariable Long id, Model model) {
        Account account = accountCredService.getAccountById(id);
        model.addAttribute("account", account);
        return "account-details";
    }

    @PostMapping("/accounts/{id}/deposit")
    public String depositToAccount(@PathVariable Long id, @RequestParam double amount, Model model) {
        Account account = accountCredService.getAccountById(id);
        account.setBalance(account.getBalance() + amount);
        accountCredService.saveAccount(account);
        return "redirect:/accounts/{id}";
    }
    @PostMapping("/accounts/{id}/withdraw")
    public String withdrawFromCredAccount(@PathVariable Long id, @RequestParam double amount, Model model) {
        Account account = accountCredService.getAccountById(id);
        if (account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
            UserService.AccountService accountService = null;
            accountService.saveAccount(account);
        }
        return "redirect:/accounts/{id}";
    }
    @GetMapping("/profile")
    public String profile(Model model) {
        User user = userService.getCurrentUser();
        model.addAttribute("user", user);
        return "profile";
    }
    @PostMapping("/profile")
    public String updateProfile(@ModelAttribute User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "profile";
        }
        userService.updateUser(user);
        return "redirect:/";
}
    @GetMapping("/documents")
    public String documents(Model model) {
        User user = userService.getCurrentUser();
        List<org.example.model.Document> documents = documentService.getDocumentsByUser(user);
        model.addAttribute("documents", documents);
        return "documents";
    }

    @PostMapping("/documents")
    public String uploadDocument(@RequestParam("file") MultipartFile file, Model model) {
        User user = userService.getCurrentUser();
        Document document = (Document) documentService.saveDocument(user, file);
        model.addAttribute("document", document);
        return "redirect:/documents";
    }


}
/*package org.example.controller;

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