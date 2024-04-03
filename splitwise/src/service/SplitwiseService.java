package service;

import models.ActionType;
import models.Balance;
import models.ExpenseType;
import models.User;
import repository.UserRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static java.lang.System.exit;

public class SplitwiseService {
    Map<Double, User> userPaidMap;
    UserRepository userRepository;

    public SplitwiseService(UserRepository userRepository){
        userPaidMap = new HashMap<>();
        this.userRepository = userRepository;
    }
    public void processActionType(){
        while(true) {
            Scanner scanner = new Scanner(System.in);
            String[] commands = scanner.nextLine().split(" ");

            ActionType actionType = ActionType.fromString(commands[0]);
            switch (actionType) {
                case EXPENSE: {
                    double amountPaid = Double.parseDouble(commands[2]);
                    User userWhoPaid = userRepository.getUserById(commands[1]);
                    userPaidMap.put(amountPaid, userWhoPaid);
                    createExpense(commands, amountPaid, userWhoPaid);
                    break;
                }
                case SHOW: {
                    if (commands.length == 1) {
                        userRepository.showAllBalances();
                    } else {
                        String user = commands[1];
                        userRepository.showBalanceByUser(user);
                    }
                    break;
                }
                case QUIT: {
                    System.out.println(" Quitting the App Now");
                    exit(200);
                    break;
                }
                default: {
                    System.out.println(" Please enter a valid action type");
                }
            }
        }
    }

    public void createExpense(String[] commands, double amountPaid, User userWhoPaid){
        int noOfUsersWhoOwe = Integer.parseInt(commands[3]);
        ExpenseType expenseType = ExpenseType.fromString(commands[3+noOfUsersWhoOwe+1]);
        switch(expenseType){
            case EQUAL: {
                double amountToBePaid = amountPaid/noOfUsersWhoOwe;
                for(int i =0; i<noOfUsersWhoOwe; i++){
                    String userWhoOwesId = commands[4+i];
                    User userWhoOwes = userRepository.getUserById(userWhoOwesId);
                    List<Balance> balanceListForUserWhoOwes = userWhoOwes.getBalanceListOwedToOtherUsers();
                    if(balanceListForUserWhoOwes.stream().anyMatch(balance -> balance.getOwedToUser().equals(userWhoPaid))){
                        Balance alreadyOwedBalance = balanceListForUserWhoOwes.stream().filter(balance -> balance.getOwedToUser().equals(userWhoPaid)).findFirst().get();
                        double amountOwed = alreadyOwedBalance.getAmount() + amountToBePaid;
                        balanceListForUserWhoOwes.stream().filter(balance -> balance.getOwedToUser().equals(userWhoPaid)).forEach(balance -> balance.setAmount(amountOwed));
                    }
                    else{
                        Balance balance = new Balance();
                        balance.setOwedToUser(userWhoPaid);
                        balance.setAmount(amountToBePaid);
                        balanceListForUserWhoOwes.add(balance);
                    }
                }
                break;
            }
            case EXACT: {
                int startIndex = 3 + noOfUsersWhoOwe + 2;
                int startIndexForUser = 4;
                for(int i = 0 ; i<noOfUsersWhoOwe; i++){
                    double amountToBePaid = Double.parseDouble(commands[startIndex + i]);
                    User userWhoOwes = userRepository.getUserById(commands[startIndexForUser + i]);
                    List<Balance> balanceListForUserWhoOwes = userWhoOwes.getBalanceListOwedToOtherUsers();
                    if(balanceListForUserWhoOwes.stream().anyMatch(balance -> balance.getOwedToUser().equals(userWhoPaid))){
                        Balance alreadyOwedBalance = balanceListForUserWhoOwes.stream().filter(balance -> balance.getOwedToUser().equals(userWhoPaid)).findFirst().get();
                        double amountOwed = alreadyOwedBalance.getAmount() + amountToBePaid;
                        balanceListForUserWhoOwes.stream().filter(balance -> balance.getOwedToUser().equals(userWhoPaid)).forEach(balance -> balance.setAmount(amountOwed));
                    }
                    else{
                        Balance balance = new Balance();
                        balance.setOwedToUser(userWhoPaid);
                        balance.setAmount(amountToBePaid);
                        balanceListForUserWhoOwes.add(balance);
                    }
                }
                break;
            }
            case PERCENT: {
                int startIndex = 3 + noOfUsersWhoOwe + 2;
                int startIndexForUser = 4;
                for(int i = 0 ; i<noOfUsersWhoOwe; i++){
                    double percent = Double.parseDouble(commands[startIndex + i]);
                    double amountToBePaid = (amountPaid*percent)/100;
                    User userWhoOwes = userRepository.getUserById(commands[startIndexForUser + i]);
                    List<Balance> balanceListForUserWhoOwes = userWhoOwes.getBalanceListOwedToOtherUsers();
                    if(balanceListForUserWhoOwes.stream().anyMatch(balance -> balance.getOwedToUser().equals(userWhoPaid))){
                        Balance alreadyOwedBalance = balanceListForUserWhoOwes.stream().filter(balance -> balance.getOwedToUser().equals(userWhoPaid)).findFirst().get();
                        double amountOwed = alreadyOwedBalance.getAmount() + amountToBePaid;
                        balanceListForUserWhoOwes.stream().filter(balance -> balance.getOwedToUser().equals(userWhoPaid)).forEach(balance -> balance.setAmount(amountOwed));
                    }
                    else{
                        Balance balance = new Balance();
                        balance.setOwedToUser(userWhoPaid);
                        balance.setAmount(amountToBePaid);
                        balanceListForUserWhoOwes.add(balance);
                    }
                }
                break;
            }
        }

    }
}
