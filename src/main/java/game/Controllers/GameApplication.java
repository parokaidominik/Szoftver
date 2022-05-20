package game.Controllers;

import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

import game.PlayerManagement.PlayerStats;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.tinylog.Logger;

public class GameApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        /**
         * Reads the JSON file that stores data.
         */
        JSONParser jp = new JSONParser();
        try (FileReader reader = new FileReader("info.json")){
            Object obj = jp.parse(reader);
            JSONArray ja = (JSONArray) obj;
            ja.forEach(jo -> parseJSON((JSONObject) jo));
            Logger.info("JSON File: "+ja);
        }
        catch (IOException | ParseException e){
            Logger.error(e);
        }
        Logger.info("Read the players data from the JSON file.");

        /**
         * Starts the menu.
         */
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXML/menu.fxml")));
        stage.setTitle("BLUE vs RED");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    /**
     * Stores the players data that we read from the JSON file.
     */
    private static void parseJSON(JSONObject jo){
        String name = (String) jo.get("Name");
        String wins = (String) jo.get("WINS");
        Long l = (Long) jo.get("ID");
        String m = String.valueOf(l);
        int id = Integer.parseInt(m);
        String played = (String) jo.get("PLAYED");

        PlayerStats.setStats(name,id,wins,played);
        MenuController.id = id+1;
    }

}
