package repository;

import models.Balance;
import models.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository {
    Map<String, User> userMap;
    public UserRepository(){
        this.userMap = new HashMap<>();
    }

    public void addUser(User user){
        userMap.put(user.getId(), user);
    }

    public User getUserById(String userId){
        return userMap.get(userId);
    }

    public void showAllBalances(){
        for(Map.Entry<String, User> user : userMap.entrySet()){
            String userId = user.getKey();
            User eachUser = user.getValue();
            String userName = eachUser.getUserName();
            List<Balance> balanceListForEachUser = eachUser.getBalanceListOwedToOtherUsers();
            int i =0;
            while(i< balanceListForEachUser.size()){
                Balance balance = balanceListForEachUser.get(i);
                System.out.println(userName + " owes " + balance.getOwedToUser().getUserName() + ": " + balance.getAmount());
                i++;
            }
        }
    }

    public void showBalanceByUser(String user){
        User userToShow = userMap.get(user);
        List<Balance> balanceList = userToShow.getBalanceListOwedToOtherUsers();
        int i = 0;
        while(i< balanceList.size()){
            Balance balance = balanceList.get(i);
            System.out.println(userToShow.getUserName() + " owes " + balance.getOwedToUser().getUserName() + ": " + balance.getAmount());
            i++;
        }
    }


}
