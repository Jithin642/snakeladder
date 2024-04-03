package models;

import java.util.HashMap;

public class Entities {
    private HashMap<Integer, Integer> snakes;
    private HashMap<Integer, Integer> ladders;
    private HashMap<Integer, String> players;
    private static Entities instance;

    public Entities(){
        this.snakes = new HashMap<>();
        this.players = new HashMap<>();
        this.ladders = new HashMap<>();
    }

    public HashMap<Integer, Integer> getSnakes(){
        return snakes;
    }
    public void setSnakes(int startPosition, int endPosition){
        snakes.put(startPosition, endPosition);
    }

    public HashMap<Integer, Integer> getLadders(){
        return ladders;
    }
    public void setLadders(int startPosition, int endPosition){
        ladders.put(startPosition, endPosition);
    }

    public HashMap<Integer, String> getPlayers(){
        return players;
    }
    public void setPlayers(int playerNumber, String playerName){
        players.put(playerNumber, playerName);
    }

    public static Entities getInstance(){
        if(instance == null){
            instance = new Entities();
        }
        return instance;
    }
}
