package sg.edu.nus.iss.workshop22.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public class FundsTransfer {

    private String id;

    @Size(min=10, max=10, message="The length of the account id should be 10 characters")
    private String fromAccount;

    @Size(min=10, max=10, message="The length of the account id should be 10 characters")
    private String toAccount;

    @Min(value=10, message="The minimum transfer amount is $10")
    private Double amount;

    private String comments;

    public FundsTransfer() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
    }

    public String getToAccount() {
        return toAccount;
    }

    public void setToAccount(String toAccount) {
        this.toAccount = toAccount;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

}
