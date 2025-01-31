package exercise1;

import java.time.LocalDate;

public class PlayerDetail {
	
	 private Integer playerID;
	 private String firstName;
	 private String lastName;
	 private String address;
	 private String postalCode;
	 private String province;
	 //private Double phoneNumber;
	 private Integer phoneNumber;
	 private String gameTitle;
	 private Integer gameScore;
	 private LocalDate datePlayed;
	 
	 public PlayerDetail(Integer playerID, String firstName, String lastName,String address, String postalCode,
			 			 String province, Integer phoneNumber, String gameTitle, Integer gameScore, LocalDate datePlayed) {
	  this.playerID    = playerID;
	  this.firstName    = firstName;
	  this.lastName    = lastName;
	  this.address     = address;
	  this.postalCode  = postalCode;
	  this.province    = province;
	  this.phoneNumber = phoneNumber;
	  this.gameTitle   = gameTitle;
	  this.gameScore   = gameScore;
	  this.datePlayed  = datePlayed;

	 }

	 public PlayerDetail() {
	    }


	public Integer getPlayerID() {
		return playerID;
	}

	public void setPlayerID(Integer playerID) {
		this.playerID = playerID;
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

	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getGameTitle() {
		return gameTitle;
	}

	public void setGameTitle(String gameTitle) {
		this.gameTitle = gameTitle;
	}

	public Integer getGameScore() {
		return gameScore;
	}

	public void setGameScore(Integer gameScore) {
		this.gameScore = gameScore;
	}

	public LocalDate getDatePlayed() {
		return datePlayed;
	}

	public void setDatePlayed(LocalDate datePlayed) {
		this.datePlayed = datePlayed;
	}

}
