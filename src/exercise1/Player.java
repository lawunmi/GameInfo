package exercise1;

import java.time.LocalDate;

public class Player {
	 private String firstName;

	 private String lastName;

	 private String address;

	 private String postalCode;

	 private String province;

	 private Double phoneNumber;
	 
	 private String gameTitle;
	 private int score;
	 private LocalDate playingDate;

	 public Player(String firstName, String lastName, String address, String postalCode,

	   String province, Double phoneNumber, String gameTitle, int score, LocalDate playingDate) {

	  this.firstName = firstName;

	  this.lastName = lastName;

	  this.address = address;

	  this.postalCode = postalCode;

	  this.province = province;

	  this.phoneNumber = phoneNumber;

	  this.gameTitle = gameTitle;
      this.playingDate = playingDate;
      this.score = score;


	 }

	 public Player() {

	 }

	 public String getFirstName() {

	  return firstName;

	 }

	 public void setFirstName(String firstName) {

	  this.firstName = firstName;

	 }

	 public String getLastName() {

	  return lastName;

	 }

	 public void setLastName(String lastName) {

	  this.lastName = lastName;

	 }

	 public String getAddress() {

	  return address;

	 }

	 public void setAddress(String address) {

	  this.address = address;

	 }

	 public String getPostalCode() {

	  return postalCode;

	 }

	 public void setPostalCode(String postalCode) {

	  this.postalCode = postalCode;

	 }

	 public String getProvince() {

	  return province;

	 }

	 public void setProvince(String province) {

	  this.province = province;

	 }

	 public Double getPhoneNumber() {

	  return phoneNumber;

	 }

	 public void setPhoneNumber(Double phoneNumber) {

	  this.phoneNumber = phoneNumber;

	 }
	 
	 @Override

	 public String toString() {

	     return this.getFirstName()+" "+this.getLastName();

	 }	 

	 public void setGameTitle(String gameTitle) {

	  this.gameTitle = gameTitle;

	 }

	 public String getGameTitle() {

	  return gameTitle;

	 }public LocalDate getPlayingDate() {
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