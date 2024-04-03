package models;

import java.util.Random;

public class Dice {
    private int numberOnDice;
    private Random random;

    public Dice(int n){
        this.random = new Random();
        this.numberOnDice = n;
    }

    public int getNumberOnDice(){
        return random.nextInt(this.numberOnDice)+1;
    }
}
