package sg.edu.nus.iss.workshop22.models;

public class Account {

    private String account_id;

    private String name;

    private Double balance;

    public Account() {
    }

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return name + " (" + account_id + ")";
    }

    

    
    
}
