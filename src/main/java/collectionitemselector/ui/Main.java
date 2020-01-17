package collectionitemselector.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage stage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("collectionitemselector/fxml/Main.fxml"));
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
