package sg.edu.nus.iss.workshop22.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.edu.nus.iss.workshop22.models.Account;
import sg.edu.nus.iss.workshop22.models.FundsTransfer;
import sg.edu.nus.iss.workshop22.repositories.AccountRepository;

@Service
public class FundsTransferService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private LogAuditService logAuditService;
    
    @Transactional
    public FundsTransfer saveFundsTransfer(FundsTransfer fundsTransfer) {
        accountRepository.debitAccountBalance(fundsTransfer.getFromAccount(), fundsTransfer.getAmount());
        accountRepository.creditAccountBalance(fundsTransfer.getToAccount(), fundsTransfer.getAmount());
        fundsTransfer.setId(generateUuid());
        logAuditService.logFundsTransfer(fundsTransfer);
        return fundsTransfer;
    }

    private String generateUuid() {
        return UUID.randomUUID().toString().substring(0, 8);
    }
}
