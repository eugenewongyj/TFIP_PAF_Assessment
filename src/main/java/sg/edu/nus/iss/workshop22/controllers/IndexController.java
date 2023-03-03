package sg.edu.nus.iss.workshop22.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.nus.iss.workshop22.models.Account;
import sg.edu.nus.iss.workshop22.models.FundsTransfer;
import sg.edu.nus.iss.workshop22.repositories.AccountRepository;

@Controller
@RequestMapping(path={"/", "index.html"})
public class IndexController {

    @Autowired
    private AccountRepository accountRepository;
    
    @GetMapping
    public String getFundsTransferForm(Model model) {
        List<Account> accountList = accountRepository.findAllAccounts();
        model.addAttribute("fundsTransfer", new FundsTransfer());
        model.addAttribute("accountList", accountList);
        return "index";
    }
}
