package game.Controllers;

import game.PlayerManagement.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.tinylog.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ScoreBoard implements Initializable {

        @FXML
        private TableView<Player> scoreboard;

        @FXML
        private TableColumn<Player, Integer> id;

        @FXML
        private TableColumn<Player, String> name;

        @FXML
        private TableColumn<Player, String> played;

        @FXML
        private TableColumn<Player, String> winrate;

        @FXML
        private TableColumn<Player, String> wins;

        MenuController menu = new MenuController();

        /**
         * Creates the scoreboard table with our players' data.
         */
        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
                name.setCellValueFactory(new PropertyValueFactory<>("name"));
                id.setCellValueFactory(new PropertyValueFactory<>("id"));
                played.setCellValueFactory(new PropertyValueFactory<>("played"));
                wins.setCellValueFactory(new PropertyValueFactory<>("wins"));
                winrate.setCellValueFactory(new PropertyValueFactory<>("winrate"));
                scoreboard.setItems(menu.list);
        }

        /**
         * Takes us back to the menu.
         */
        @FXML
        private void goMenu(ActionEvent event)throws IOException {
                Logger.info("Loading menu...");
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXML/menu.fxml")));
                stage.setScene(new Scene(root));
                stage.show();
                scoreboard.getItems().clear();
        }
}


