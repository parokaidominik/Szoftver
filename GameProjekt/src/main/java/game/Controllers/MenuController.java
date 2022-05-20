package game.Controllers;

import game.PlayerManagement.Player;
import game.PlayerManagement.PlayerStats;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.tinylog.Logger;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class MenuController {

    @FXML
    private TextField player1;
    @FXML
    private TextField player2;

    public static String p1 = "BLUE";
    public static String p2 = "RED";
    PlayerStats stats = new PlayerStats();
    public static int id = 0;
    public static ObservableList<Player> list = FXCollections.observableArrayList();


    /**
     * Loads the game and starts it.
     * @param event Mouse click on START button.
     */
    @FXML
    private void startGame(ActionEvent event)throws IOException {
        int currentPlayed;
        currentPlayed = Integer.parseInt(stats.getPlayed(stats.getID(getPlayerOne()))) +1;
        stats.setPlayed(currentPlayed, stats.getID(getPlayerOne()));
        currentPlayed = Integer.parseInt(stats.getPlayed(stats.getID(getPlayerTwo()))) +1;
        stats.setPlayed(currentPlayed, stats.getID(getPlayerTwo()));

        if(p1.equals("BLUE") || p2.equals("RED")){Logger.info("Didn't set the nickname(s) so Player name(s) set to default.");}

        Logger.info("Starting game...","BLUE PLAYER: "+getPlayerOne());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXML/game.fxml")));
        stage.setScene(new Scene(root));
        stage.show();
        Logger.info("BLUE PLAYER: "+getPlayerOne());
        Logger.info("RED PLAYER: "+getPlayerTwo());
    }

    /**
     * Saves our added names.
     */
    @FXML
    private void saveNames(){
        p1 = player1.getText();
        p2 = player2.getText();
        if(p1.equals("")){p1 = "BLUE";}
        if(p2.equals("")){p2 = "RED";}
        Logger.info("Name(s) saved successfully.");

        if(!stats.isExist(p1)){
            PlayerStats.setStats(p1,id,"0","0");
            id++;}
        if(!stats.isExist(p2)){
            PlayerStats.setStats(p2,id,"0","0");
            id++;}
    }

    /**
     * Show us the scoreboard.
     */
    public void scoreBoard(ActionEvent event)throws IOException{
        Logger.info("Loading scoreboard....");
        for(int i=0;i<id;i++){
            list.add(new Player(stats.getName(i),i,stats.getPlayed(i),stats.getWins(i),stats.getWinPercentage(i)));
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXML/scoreboard.fxml")));
        stage.setScene(new Scene(root));
        stage.show();
    }


    /**
     * Name getters.
     * @return Returns the current player names.
     */
    public String getPlayerOne(){return p1;}
    public String getPlayerTwo(){return p2;}


    /**
     * Exits game, and saves the current player data to JSON.
     */
    @FXML
    private void exitGame(){
        JSONArray playerList = new JSONArray();
        for(int i = 0;i<id;i++){
            playerList.add(stats.toJSONObject(i));}

        try(FileWriter file = new FileWriter("info.json")){
            file.write(playerList.toJSONString());
            file.flush();
        }
        catch (IOException e){e.printStackTrace();}
        Logger.info("Saved the players data to JSON file.");
        Logger.info("Exiting....");
        Platform.exit();
    }
}
