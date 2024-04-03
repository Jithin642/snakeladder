package models;

public class Balance {
    private User owedToUser;
    private double amount;

    public Balance(){
        this.amount = 0;
    }

    public void setOwedToUser(User user){
        this.owedToUser = user;
    }
    public User getOwedToUser(){
        return owedToUser;
    }

    public void setAmount(double amount){
        this.amount = amount;
    }
    public double getAmount(){
        return amount;
    }
}
