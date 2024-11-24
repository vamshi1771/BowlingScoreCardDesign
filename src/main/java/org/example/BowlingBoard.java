package org.example;

public class BowlingBoard implements ScoringBoard {
    private int frameScore = 0;
    private int previousScore = 0;
    private int totalScore = 0;

    private String previousFrameName = "OPEN";
    private int noOfPinsLeft;

    private int bonusRolls = 0; // To handle strike/spare bonuses

    void setFrameScore(int frameScore){
        this.frameScore = frameScore;
    }
    void setPreviousScore(int previousScore){
        this.previousScore = previousScore;
    }
    void setTotalScore(int  totalScore){
        this.totalScore = totalScore;
    }
    void setNoOfPinsLeft(int pins){
        this.noOfPinsLeft = pins;
    }
    int getPreviousScore(){
        return previousScore;
    }
    int getTotalScore(){
        return totalScore;
    }
    int getNoOfPinsLeft(){
        return noOfPinsLeft;
    }
    int getFrameScore(){
        return frameScore;
    }
    public void knockDownPins(int pins) {
        noOfPinsLeft -= pins;
    }
    @Override
    public int startGame(int score, int attempt) {

        if (bonusRolls > 0) { // Add bonus points for previous strikes/spares
            totalScore += score;
            bonusRolls--;
        }

        if (attempt == 1) {
            if (previousFrameName.equals("OPEN")) {
                frameScore = score;
                return totalScore;
            } else if (previousFrameName.equals("SPARE")) {
                int val = frameScore;
                frameScore = score;
                previousScore = totalScore + val + score;
                totalScore = previousScore;
                return totalScore;
            } else { // Strike case
                bonusRolls = 2; // Strike gets 2 bonus rolls
                frameScore = score;
                return totalScore; // Score will be updated after bonus rolls
            }
        } else { // 2nd attempt in the frame
            frameScore += score;
            if (frameScore < 10) { // Open frame
                totalScore += frameScore;
                previousScore = totalScore;
                previousFrameName = "OPEN";
                return totalScore;
            } else { // Spare case
                totalScore += frameScore; // For a spare, add 10 now, and next roll gives the bonus
                previousFrameName = "SPARE";
                bonusRolls = 1; // Spare gets 1 bonus roll
                return totalScore;
            }
        }




















//        if(attempt == 1) {
//            if (previousFrameName == "OPEN") { //initial Frame will be OPEN
//                frameScore = score;
//                return previousScore;
//            }
//            else if(previousFrameName == "SPARE") { // if previous Frame is SPARE I need to add current  frame 1st attempt value for previous Frame total
//                int val = frameScore;
//                setFrameScore(score);
//                previousScore = totalScore + val + score;
//                return totalScore + val + score;
//
//            }
//            else { // Strike CASE
//                attempt++;
//
//            }
//        }
//            else{ // for 2nd attempt in the frame
//                frameScore+=score;
//                if(frameScore < 10 ){ // OPEN FRAME CASE
//                    totalScore+= frameScore;
//                    previousScore = totalScore;
//                    previousFrameName = "OPEN";
//                    return totalScore;
//                }
//                else {
//                    if(frameScore == 10){ // SPARE CASE
//                        previousFrameName = "SPARE"; // at the attempt 2 of that frame is SPARE it become PreviousFrame = SPARE For Next Framel
//                        return totalScore;
//                    }
//                }
        }

//        if((attempt == 1 && (score < 10 || score == 10) && previousFrameName == "OPEN" ) || (attempt == 2 && totalScore == 10) ){
//            return previousScore;
//        }
//        else if(attempt == 2 && totalScore < 10){
//            return totalScore;
//        }
//        else if((attempt == 1 && previousFrameName == "spare") || (attempt == 2 && previousFrameName == "Strike")){
//            return totalScore;
//        }
//    }
}
