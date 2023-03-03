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
        if (fundsTransfer.getFromAccount().equals(fundsTransfer.getToAccount())) {
            ObjectError err = new ObjectError("sameAccount", "The from account should not be the same as the to account");
            bindingResult.addError(err);
        }

        if (!fundsTransferService.isAccountValid(fundsTransfer.getFromAccount())) {
            ObjectError err = new ObjectError("fromAccountDoesNotExist", "The from account does not exist");
            bindingResult.addError(err);
        }

        if (!fundsTransferService.isAccountValid(fundsTransfer.getToAccount())) {
            ObjectError err = new ObjectError("toAccountDoesNotExist", "The to account does not exist");
            bindingResult.addError(err);
        }

        // Where to put the mapper for DTO to model.
        // If you put b
        
        if (bindingResult.hasErrors()) {
            List<Account> accountList = accountRepository.findAllAccounts();
            model.addAttribute("accountList", accountList);
            return "index";
        }

        FundsTransfer fundsTransferSaved = fundsTransferService.saveFundsTransfer(fundsTransfer);
        model.addAttribute("fundsTransferSaved", fundsTransferSaved);
        return "result";
    }
    
}
