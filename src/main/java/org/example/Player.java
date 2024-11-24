package org.example;


public class Player {
    private String Name;
    private int frameScore;
    private int currentScore;
    private int previousScore;
    private int totalScore;
    private String previousFrameName;

    private int noOfPinsLeft;

    private BowlingBoard board;

     Player(String name, int previousScore, int noOfPinsLeft, int totalScore,ScoringBoard Board,String previousFrameName){
         this.Name = name;
         this.totalScore = totalScore;
         this.previousScore = previousScore;
         this.board = (BowlingBoard) Board;
         this.noOfPinsLeft = noOfPinsLeft;
         this.previousFrameName = previousFrameName;
         board.setFrameScore(frameScore);
         board.setTotalScore(0);
         board.setNoOfPinsLeft(noOfPinsLeft);
         board.setPreviousScore(previousScore);
     }


    void SetBoard(ScoringBoard board){
        this.board = (BowlingBoard) board;
    }
    void setNoOfPinsLeft(int pins){
         this.noOfPinsLeft = pins;
    }
    String getName(){
      return Name;
    }
    int getPreviousScore(){
        return board.getPreviousScore();
    }
    int getTotalScore(){
        return board.getTotalScore();
    }
    int getNoOfPinsLeft(){
            return noOfPinsLeft;
    }

    public void setPlayerValues(BowlingBoard board) {
        previousScore = board.getPreviousScore();
        totalScore = board.getTotalScore();
        frameScore = board.getFrameScore();
    }


    int play(int score, int attempt){
           int val =  board.startGame(score,attempt);
            noOfPinsLeft-=score;
            setPlayerValues(board);
            return val;
    }
}
