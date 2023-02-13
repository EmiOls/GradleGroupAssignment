package core;

public class Player {
    private String name;
    private int score;
    private int highScore;
    private int playedRounds;


    public Player(String name) {
        this.name = name;
        score = 0;
        highScore = 0;
        playedRounds = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    public int getPlayedRounds() {
        return playedRounds;
    }

    public void setPlayedRounds(int playedRounds) {
        this.playedRounds = playedRounds;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
