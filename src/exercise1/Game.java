package exercise1;

public class Game {

	 
	 private String gameTitle;

	 public Game(String gameTitle) {

	  this.gameTitle = gameTitle;

	 }

	 public Game() {

	 }

	 public String getGameTitle() {

	  return gameTitle;

	 }

	 public void setGameTitle(String gameTitle) {

	  this.gameTitle = gameTitle;

	 }
	 
	 @Override
	 public String toString() {
	        return getGameTitle();
	  } 
	}