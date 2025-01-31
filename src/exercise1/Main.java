package exercise1;
	
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.FontWeight;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;
import java.time.LocalDate;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		BorderPane root = new BorderPane();
		GridPane grid   = new GridPane();
		FlowPane flow   = new FlowPane();
		Scene scene = new Scene(root,1200,700);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setTitle("Player Registration");
		primaryStage.setScene(scene);
		primaryStage.show();
		root.setTop(grid);
		root.setBottom(flow);
        grid.setPadding(new Insets(10));
        flow.setPadding(new Insets(10));
		grid.setVgap(10);
		grid.setHgap(10);
			
		Label infoLabel = new Label("Player Information:");
		grid.add(infoLabel, 0, 0);
		
		//Label labelOutput = new Label("Player Information:");
		//grid.add(infoLabel, 0, 0);
		
		TextField firstName = new TextField();
		firstName.setPrefHeight(40);
		firstName.setPrefWidth(350);
		grid.add(new Label("First Name: "), 0, 2);
		grid.add(firstName, 2, 2);
		
		TextField lastName = new TextField();
		lastName.setPrefHeight(40);
		lastName.setPrefWidth(350);
		grid.add(new Label("Last Name: "), 0, 3);
		grid.add(lastName, 2, 3);
		
		TextField address = new TextField();
		address.setPrefHeight(40);
		address.setPrefWidth(350);
		grid.add(new Label("Address: "), 0, 4);
		grid.add(address, 2, 4);
		
		TextField province = new TextField();
		province.setPrefHeight(40);
		province.setPrefWidth(350);
		grid.add(new Label("Province: "), 0, 5);
		grid.add(province, 2, 5);
		
		TextField postalCode = new TextField();
		postalCode.setPrefHeight(40);
		postalCode.setPrefWidth(350);
		grid.add(new Label("Postal Code: "), 0, 6);
		grid.add(postalCode, 2, 6);
		
		TextField phoneNumber = new TextField();
		phoneNumber.setPrefHeight(40);
		phoneNumber.setPrefWidth(350);
		grid.add(new Label("Phone Number: "), 0, 7);
		grid.add(phoneNumber, 2, 7);
		
		TextField playerID = new TextField();
		playerID.setPrefHeight(40);
		playerID.setPrefWidth(350);
		grid.add(new Label("Update Player by ID: "), 4, 0);
		grid.add(playerID, 5, 0);
		Button updateButton = new Button("Update");
		grid.add(updateButton, 6, 0);
		updateButton.setMaxHeight(40);
		updateButton.setMaxWidth(150);
		
		Label gameInfo = new Label("Game Information:");
		grid.add(gameInfo, 4, 4);
		
		TextField gameTitle = new TextField();
		gameTitle.setPrefHeight(40);
		gameTitle.setPrefWidth(350);
		grid.add(new Label("Game Title: "), 4, 5);
		grid.add(gameTitle, 5, 5);
		
		TextField gameScore = new TextField();
		gameScore.setPrefHeight(40);
		gameScore.setPrefWidth(350);
		grid.add(new Label("Game Score: "), 4, 6);
		grid.add(gameScore, 5, 6);
		
		//TextField datePlayed = new TextField();
		DatePicker datePlayed = new DatePicker();
		datePlayed.setPrefHeight(40);
		datePlayed.setPrefWidth(350);
		grid.add(new Label("Date Played: "), 4, 7);
		grid.add(datePlayed, 5, 7);
		
		Button createButton = new Button("Create Player");
		grid.add(createButton, 5, 10);
		createButton.setMaxHeight(40);
		createButton.setMaxWidth(350);
		Button displayButton = new Button("Display All Players");
		grid.add(displayButton, 6, 10);
		displayButton.setMaxHeight(40);
		displayButton.setMaxWidth(150);
		
		createButton.setOnAction(e -> {
			String fName = firstName.getText();
			String lName = lastName.getText();
			String add = address.getText();
			String pcode = postalCode.getText();
			String pr = province.getText();
			String phnNum = phoneNumber.getText();
			String gTitle = gameTitle.getText();
			//String dateValue = datePlayed.getText();
			java.time.LocalDate dateValue = datePlayed.getValue();
			String gScore = gameScore.getText();
			Integer score = Integer.parseInt(gScore);
			double intPhoneNum = Double.parseDouble(phnNum);
			
			Player player = new Player(fName, lName, add, pcode, pr, intPhoneNum, gTitle, score, dateValue);
			Game game = new Game(gTitle);
			PlayerGame playergame = new PlayerGame(dateValue, score);
			
			PlayerInfo(player);
			

			firstName.clear();
			lastName.clear();
			address.clear();
			postalCode.clear();
			province.clear();
			phoneNumber.clear();
			gameTitle.clear();
			gameScore.clear();
		});
		
		displayButton.setOnAction(e -> {
			displayReport();
		});
		
		updateButton.setOnAction(e -> {
			/*String fName = firstName.getText();
			String lName = lastName.getText();
			String add = address.getText();
			String pcode = postalCode.getText();
			String phnNum = phoneNumber.getText();
			String dateValue = datePlayed.getText();
			java.time.LocalDate dateValue = datePlayed.getValue();
			double intPhoneNum = Double.parseDouble(phnNum);*/
			String pr = province.getText();
			String gTitle = gameTitle.getText();
			String gScore = gameScore.getText();
			Integer score = Integer.parseInt(gScore);
			String pID = playerID.getText();
			Integer pid = Integer.parseInt(pID);
			System.out.println("pid" + pid);
			
			//Player player = new Player(fName, lName, add, pcode, pr, intPhoneNum, gTitle, score, dateValue);
			//Game game = new Game(gTitle);
			//PlayerGame playergame = new PlayerGame(dateValue, score);
			
			updatePlayer(pr, gTitle, score, pid);
			
		});
		
		
	}


	private static void PlayerInfo(Player player) {

		Connection conn = DbConnection.getDBConnection();

		try {	
			String playerQuery = "INSERT INTO player (first_name, last_name, address, postal_code, province, phone_number, game_title, game_score, playing_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement statement = conn.prepareStatement(playerQuery);
						statement.setString(1, player.getFirstName());
						statement.setString(2, player.getLastName());
						statement.setString(3, player.getAddress());
						statement.setString(4, player.getPostalCode());
						statement.setString(5, player.getProvince());
						statement.setDouble(6, player.getPhoneNumber());
						statement.setString(7, player.getGameTitle());
						statement.setDouble(8, player.getScore());
						statement.setDate(9, java.sql.Date.valueOf(player.getPlayingDate()));
			int row = statement.executeUpdate();

			if (row > 0) {
				System.out.println("A row has be inserted");
			} else {
				System.out.println("An error occured");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} 

	}
	
private void GameInfo(Game game) {

		try {
			Connection conn = DbConnection.getDBConnection();
			String gameQuery = "INSERT INTO game(game_title) VALUES (?)";

			PreparedStatement statement = conn.prepareStatement(gameQuery);
						statement.setString(1, game.getGameTitle());
			int row = statement.executeUpdate();

			if (row > 0) {
				System.out.println("A row has be inserted");
			} else {
				System.out.println("An error occured");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
private void playerGameInfo(PlayerGame playergame) {
		try {
			Connection conn = DbConnection.getDBConnection();
			String pgQuery = "INSERT INTO playerandgame(playing_date, score) VALUES (?, ?)";

			PreparedStatement statement = conn.prepareStatement(pgQuery);
						statement.setDate(1, java.sql.Date.valueOf(playergame.getPlayingDate()));
						statement.setInt(2, playergame.getScore());
			int row = statement.executeUpdate();

			if (row > 0) {
				System.out.println("A row has be inserted");
			} else {
				System.out.println("An error occured");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		//conn.close();

	}

public void updatePlayer(String province, String gTitle, int gScore, int pID){
	
	Connection conn = DbConnection.getDBConnection();
	try{
		/*PreparedStatement statement = conn.prepareStatement("UPDATE PLAYER SET FIRST_NAME = ?, LAST_NAME = ?, ADDRESS = ?, POSTAL_CODE = ?, PROVINCE = ?,"
							+	"PHONE_NUMBER = ?, GAME_TITLE = ?, GAME_SCORE = ?, PLAYING_DATE = ? WHERE PLAYER_ID = ?");*/
		
		PreparedStatement statement = conn.prepareStatement("UPDATE PLAYER SET PROVINCE = ?, GAME_TITLE = ?, GAME_SCORE = ? WHERE PLAYER_ID = ?");
		
		//statement.setString(1, fName);
		//statement.setString(2, lName);
		//statement.setString(3, address);
		//statement.setString(4, pCode);
		statement.setString(1, province);
		//statement.setDouble(6, pNum);
		statement.setString(2, gTitle);
		statement.setInt(3, gScore);
		//statement.setDate(9, java.sql.Date.valueOf(pDate));
		statement.setInt(4, pID);
		
		int row = statement.executeUpdate();

			/*if (row > 0) {
				System.out.println("A row has been updated");
			} else {
				System.out.println("An error occured");
			}*/

		} catch (Exception e) {
			e.printStackTrace();
		} 
						
}

private void displayReport() {
    try (Connection connection = DbConnection.getDBConnection();
         PreparedStatement statement = connection.prepareStatement("SELECT * FROM PLAYER ORDER BY PLAYER_ID")) {

        //statement.setInt(1, playerId);
        try (ResultSet resultSet = statement.executeQuery()) {

            ObservableList<PlayerDetail> playerDetails = FXCollections.observableArrayList();

            while (resultSet.next()) {
                PlayerDetail playerDetail = new PlayerDetail();
                playerDetail.setPlayerID(resultSet.getInt("PLAYER_ID"));
                playerDetail.setFirstName(resultSet.getString("FIRST_NAME"));
                playerDetail.setLastName(resultSet.getString("LAST_NAME"));
                playerDetail.setAddress(resultSet.getString("ADDRESS"));
                playerDetail.setPostalCode(resultSet.getString("POSTAL_CODE"));
                playerDetail.setProvince(resultSet.getString("PROVINCE"));
                playerDetail.setPhoneNumber(resultSet.getInt("PHONE_NUMBER"));
                playerDetail.setGameTitle(resultSet.getString("GAME_TITLE"));
                playerDetail.setGameScore(resultSet.getInt("GAME_SCORE"));
                playerDetail.setDatePlayed(resultSet.getDate("PLAYING_DATE").toLocalDate());
                playerDetails.add(playerDetail);
            }

            if (playerDetails.isEmpty()) {
                System.out.println("No data found");
            } else {
                //System.out.println("Data found for Player ID: " + playerId);
                playerDetails.forEach(System.out::println);
                dataTable(playerDetails);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
}

	
private void dataTable(ObservableList<PlayerDetail> playerDetails){
	TableView<PlayerDetail> tableView = new TableView<>(playerDetails);
	
	TableColumn<PlayerDetail, Integer> IdColumn = new TableColumn<>("PLAYER_ID");
    IdColumn.setCellValueFactory(new PropertyValueFactory<>("playerID"));
	
	TableColumn<PlayerDetail, String> playerNameColumn = new TableColumn<>("FIRST_NAME");
    playerNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
	
	TableColumn<PlayerDetail, String> playerLNameColumn = new TableColumn<>("LAST_NAME");
	playerLNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
	
	TableColumn<PlayerDetail, String> addressColumn = new TableColumn<>("ADDRESS");
	addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
	
	TableColumn<PlayerDetail, String> postalCodeColumn = new TableColumn<>("POSTAL_CODE");
	postalCodeColumn.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
	
	TableColumn<PlayerDetail, String> provinceColumn = new TableColumn<>("PROVINCE");
	provinceColumn.setCellValueFactory(new PropertyValueFactory<>("province"));

	TableColumn<PlayerDetail, Double> phoneColumn = new TableColumn<>("PHONE_NUMBER");
	phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
	
	TableColumn<PlayerDetail, String> gTitleColumn = new TableColumn<>("GAME_TITLE");
	gTitleColumn.setCellValueFactory(new PropertyValueFactory<>("gameTitle"));
	
	TableColumn<PlayerDetail, String> gScoreColumn = new TableColumn<>("GAME_SCORE");
	gScoreColumn.setCellValueFactory(new PropertyValueFactory<>("gameScore"));
	
	TableColumn<PlayerDetail, LocalDate> datePlayedColumn = new TableColumn<>("PLAYING_DATE");
	datePlayedColumn.setCellValueFactory(new PropertyValueFactory<>("datePlayed"));

    //tableView.getColumns().addAll(IdColumn, playerNameColumn, addressColumn, postalCodeColumn, provinceColumn, phoneColumn, gTitleColumn, gScoreColumn, datePlayedColumn);
    //tableView.setItems(playerDetails);
	
	tableView.getColumns().setAll(IdColumn, playerNameColumn, addressColumn, postalCodeColumn, provinceColumn, phoneColumn, gTitleColumn, gScoreColumn, datePlayedColumn);
	
	//flow.getChildren().add(tableView);
	VBox reportVBox = new VBox();
    reportVBox.getChildren().add(tableView);

    Scene reportScene = new Scene(reportVBox, 1200, 700);

    Stage reportWindow = new Stage();
    reportWindow.setScene(reportScene);
    reportWindow.setTitle("Player Game Report");
    reportWindow.show();
	
}

	public static void main(String[] args) {
		launch(args);
	}
}


