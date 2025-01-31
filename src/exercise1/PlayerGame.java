package exercise1;

import java.time.LocalDate;

public class PlayerGame {

    
    private LocalDate playingDate;
    private int score;

    public PlayerGame(LocalDate playingDate, int score) {
        this.playingDate = playingDate;
        this.score = score;
    }

    public PlayerGame() {
    }

    public LocalDate getPlayingDate() {
        return playingDate;
    }

    public void setPlayingDate(LocalDate playingDate) {
        this.playingDate = playingDate;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
