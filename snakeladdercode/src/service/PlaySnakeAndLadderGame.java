package service;

import models.Dice;
import models.Entities;

import java.util.HashMap;

public class PlaySnakeAndLadderGame {
    Entities entities;
    HashMap<String, Integer> latestPositionOfPlayer;
    Dice dice;

    public PlaySnakeAndLadderGame(int n){
        this.dice = new Dice(n);
        this.entities = Entities.getInstance();
        this.latestPositionOfPlayer = new HashMap<>();
    }

    public String playGame(){
        initializePlayersGame();
        int i = -1;
        do{
            i++;
            if(i>=entities.getPlayers().size()){
                i=0;
            }
            StringBuilder str = new StringBuilder();
            String player = entities.getPlayers().get(i);
            int diceNumber = dice.getNumberOnDice();
            str.append(player);
            int startPosition = latestPositionOfPlayer.get(player);
            int endPosition = latestPositionOfPlayer.get(player) + diceNumber;
            if(!isEndPositionGreaterThan100(endPosition)){
                str.append(" rolled a ").append(diceNumber);
                latestPositionOfPlayer.put(player, endPosition);
                String sl = "";
                if(entities.getSnakes().get(endPosition)!=null){
                    int finalPosition = entities.getSnakes().get(endPosition);
                    latestPositionOfPlayer.put(player, finalPosition);
                    sl = " after Snake Dinner ";
                }
                else if(entities.getLadders().get(endPosition)!=null){
                    int finalPosition = entities.getLadders().get(endPosition);
                    latestPositionOfPlayer.put(player, finalPosition);
                    sl = " after climbing ladder ";
                }
                str.append(" and moved from ").append(startPosition).append(" to ").append(latestPositionOfPlayer.get(player)).append(sl);
            }
            System.out.println(str);
        }while(!hasPlayerWon(entities.getPlayers().get(i)));
        return entities.getPlayers().get(i);
    }

    private boolean isEndPositionGreaterThan100(int endPosition){
        return endPosition>100;
    }

    private boolean hasPlayerWon(String player){
        return latestPositionOfPlayer.get(player)==100;
    }

    private void initializePlayersGame(){
        for(int i =0; i<entities.getPlayers().size(); i++){
            latestPositionOfPlayer.put(entities.getPlayers().get(i), 0);
        }
    }
}
