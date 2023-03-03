package sg.edu.nus.iss.workshop22;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import sg.edu.nus.iss.workshop22.models.FundsTransfer;

public class Utils {

    private static final String PATTERN_FORMAT = "yyyy-MM-dd";

    public static JsonObject fundsTransferToJson(FundsTransfer fundsTransfer) {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(PATTERN_FORMAT);
        String formattedString = localDate.format(dateTimeFormatter);

        return Json.createObjectBuilder()
            .add("transactionId", fundsTransfer.getId())
            .add("date", formattedString)
            .add("from_account", fundsTransfer.getFromAccount())
            .add("to_account", fundsTransfer.getToAccount())
            .add("amount", fundsTransfer.getAmount())
            .build();
    }
    
}
