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
}
