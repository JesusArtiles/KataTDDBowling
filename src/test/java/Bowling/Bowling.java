package Bowling;

public class Bowling {
    private int currentRoll = 0;
    private int[] rolls = new int[21];

    public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    public int score() {
        int score = 0;
        int frameIndex = 0;
        for (int frame = 0;frame<10;frame++) {
            if (isStrike(frameIndex)) {
                score += 10+strikeBonus(frameIndex);
                frameIndex ++;
            }else if(isSpare(frameIndex)){
                score += 10 + spareBonus(frameIndex);
                frameIndex += 2;
            } else {
                score += getSumOfBallsInFrame(frameIndex);
                frameIndex+=2;
            }
        }

        return score;
    }

    private int getSumOfBallsInFrame(int frameIndex) {
        return rolls[frameIndex]+rolls[frameIndex+1];
    }

    private boolean isStrike(int frameIndex) {
        return rolls[frameIndex] == 10;
    }

    private int spareBonus(int frameIndex) {
        return rolls[frameIndex + 2];
    }

    private int strikeBonus(int frameIndex) {
        return rolls[frameIndex+1] + rolls[frameIndex + 2];
    }

    private boolean isSpare(int frameIndex) {
        return getSumOfBallsInFrame(frameIndex) == 10;
    }
}
