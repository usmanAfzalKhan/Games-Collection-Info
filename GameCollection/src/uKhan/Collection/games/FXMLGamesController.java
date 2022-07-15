package uKhan.Collection.games;

import uKhan.Collection.MediaTypes;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import uKhan.Collection.GameRecord;
import uKhan.Collection.MediaTypes;

/**
 * FXML Controller class loads all the IDs from the fxml
 *
 * @author Usman
 */
public class FXMLGamesController implements Initializable {

    @FXML
    private Button btnLoad;

    @FXML
    private Label lblUserMessages;

    @FXML
    private TextArea txtMainInfo;

    @FXML
    private ComboBox ddlPickGames;
    private ObservableList<GameRecord> lstObsGames;
    private ArrayList<GameRecord> lstGames = new ArrayList<GameRecord>();

    /**
     * Initializes the controller class since there is 1 button in the entire
     * UI, I uses lamda to call it and after that button's function is done, it
     * sets the combo box
     *
     * @param url
     * @param rb
     *
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnLoad.setOnAction(e -> loadFile());
        ddlPickGames.setItems(lstObsGames);
    }

    private void loadFile() {
        File file = new File("src\\uKhan\\Collection\\data\\somegames");
        if (file.exists()) {
            lblUserMessages.setText("File exists: " + file.getName());
            try ( Scanner fileScanner = new Scanner(file)) {
                while (fileScanner.hasNextLine()) {
                    String currentRecord = fileScanner.nextLine();
                    String infoSoFar = txtMainInfo.getText();
                    txtMainInfo.setText(infoSoFar + currentRecord + "\n");
                    String[] fields = currentRecord.split("\\|");
                    for (String field : fields) {
                        txtMainInfo.setText(txtMainInfo.getText() + field);
                    }

                }

                lstObsGames = FXCollections.observableArrayList(lstGames);
                ddlPickGames.setItems(lstObsGames);
            } catch (Exception ex) {
                lblUserMessages.setText("There was a problem: " + ex.getMessage());
            }

        } else {
            lblUserMessages.setText("File does not exist: " + file.getName());
        }

    }

}
