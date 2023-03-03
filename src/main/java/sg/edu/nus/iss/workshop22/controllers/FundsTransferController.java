package sg.edu.nus.iss.workshop22.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import sg.edu.nus.iss.workshop22.models.Account;
import sg.edu.nus.iss.workshop22.models.FundsTransfer;
import sg.edu.nus.iss.workshop22.repositories.AccountRepository;
import sg.edu.nus.iss.workshop22.services.FundsTransferService;

@Controller
public class FundsTransferController {

    @Autowired
    private FundsTransferService fundsTransferService;

    @Autowired
    private AccountRepository accountRepository;

    @PostMapping(path="/transfer")
    public String saveTransfer(@ModelAttribute @Valid FundsTransfer fundsTransfer, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            List<Account> accountList = accountRepository.findAllAccounts();
            model.addAttribute("accountList", accountList);
            return "index";
        }

        if (fundsTransfer.getComments().equals("hello")) {
            ObjectError err = new ObjectError("dateOfBirth", "Age must be between 10 and 100");
            // ObjectError err = new ObjectError("businessLogic", "Age must be between 10 and 100");
            bindingResult.addError(err);
            return "index";
        }

        FundsTransfer fundsTransferSaved = fundsTransferService.saveFundsTransfer(fundsTransfer);
        return "result";
    }
    
}
