package models;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String id;
    private String userName;

    private List<Balance> balanceListOwedToOtherUsers;

    public User(String id, String userName){
        this.id = id;
        this.userName = userName;
        this.balanceListOwedToOtherUsers = new ArrayList<>();
    }

    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getUserName(){
        return userName;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }

    public void setBalanceListOwedToOtherUsers(){
        this.balanceListOwedToOtherUsers = new ArrayList<>();
    }
    public List<Balance> getBalanceListOwedToOtherUsers(){
        return balanceListOwedToOtherUsers;
    }

}
