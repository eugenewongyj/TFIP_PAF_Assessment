package sg.edu.nus.iss.workshop22.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.workshop22.Utils;
import sg.edu.nus.iss.workshop22.models.FundsTransfer;

@Service
public class LogAuditService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public FundsTransfer logFundsTransfer(FundsTransfer fundsTransfer) {
        redisTemplate.opsForValue().set(fundsTransfer.getId(), Utils.fundsTransferToJson(fundsTransfer).toString());
        return fundsTransfer;
    }
    
}
