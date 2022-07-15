package uKhan.Collection.games;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
    /**
     *
     * @author Usman main method.
     */
public class GameCollection extends Application {
    /**
     * main method sets a stage.
     * @param stage
     * @throws Exception 
     */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLGames.fxml"));
        stage.setTitle("Game Collection");
        stage.setScene(new Scene(root));
        stage.show();
    }    
    /**
     * launches the FXML file
     * @param args 
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
