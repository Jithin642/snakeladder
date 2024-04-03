import models.Entities;
import service.PlaySnakeAndLadderGame;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Entities entities = Entities.getInstance();

        //Enter Snakes
//        int noOfSnakes = scanner.nextInt();
        int noOfSnakes = 9;
        entities.setSnakes(99, 1);
        entities.setSnakes(55, 10);
        entities.setSnakes(97, 11);
        entities.setSnakes(10, 4);
        entities.setSnakes(87, 20);
        entities.setSnakes(65, 35);
        entities.setSnakes(98, 64);
        entities.setSnakes(93, 73);
        entities.setSnakes(95, 75);
//        while(noOfSnakes>0){
//            int startPosition = scanner.nextInt();
//            int endPosition = scanner.nextInt();
//            entities.setSnakes(startPosition, endPosition);
//            noOfSnakes--;
//        }

        //Enter Ladders
//        int noOfLadder = scanner.nextInt();
        int noOfLadder = 8;
        entities.setLadders(2, 73);
        entities.setLadders(7, 46);
        entities.setLadders(9, 32);
        entities.setLadders(45, 68);
        entities.setLadders(71, 79);
        entities.setLadders(65, 84);
        entities.setLadders(71, 91);
        entities.setLadders(81, 100);
//        while(noOfLadder>0){
//            int startPosition = scanner.nextInt();
//            int endPosition = scanner.nextInt();
//            entities.setLadders(startPosition, endPosition);
//            noOfLadder--;
//        }


        //Enter Players
//        int noOfPlayers = scanner.nextInt();
        int noOfPlayers = 2;
//        for(int i =1; i<=noOfPlayers; i++){
//            String player = scanner.next();
//            entities.setPlayers(i, player);
//        }
        entities.setPlayers(0, "Jithin");
        entities.setPlayers(1, "Bhumika");

//        System.out.println(entities.getPlayers());


        PlaySnakeAndLadderGame playSnakeAndLadderGame = new PlaySnakeAndLadderGame(6);
        System.out.println(playSnakeAndLadderGame.playGame() + " has won the game");
    }
}