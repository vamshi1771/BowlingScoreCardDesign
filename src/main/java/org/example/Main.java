package org.example;

public class Main {
    public static void main(String[] args) {
        ScoringBoard  board = new BowlingBoard();
        Player player1 =  new Player("Alice",0,10,0, board,"OPEN");
        for (int frame = 1; frame <= 10; frame++) {
            System.out.println("Frame " + frame + ":");
            player1.setNoOfPinsLeft(10);
            for (int attempt = 1; attempt <= 2; attempt++) {
                int pinsLeft = player1.getNoOfPinsLeft();
                int currentScore = (int) (Math.random() * (pinsLeft + 1)); // Random current score
                int totalScore = player1.play(currentScore, attempt);
                System.out.println("Attempt " + attempt + ": Knocked down " + currentScore + " pins");
                System.out.println(player1.getName() + " Current Total Score => " + totalScore);
                if (currentScore == 10 && attempt == 1) { // Strike, go to next frame
                    break;
                }
            }
            System.out.println();
        }

        System.out.println("Final Score for " + player1.getName() + ": " + player1.getTotalScore());

    }
}