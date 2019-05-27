package application;
	
import java.io.IOException;

import Translation.TranslationWindow;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import rotation.RotationWindow;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("interface.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);
        new TranslationWindow(stage);
        new RotationWindow(stage);
        stage.setScene(scene);
        
        stage.setTitle("IGraphics");
        stage.show();
}

	public static void main(String[] args) {
	        Application.launch(args);
	}

	public static void newTranslation(double parseDouble, double parseDouble2) {
		
	}

	public static void newRotation(double parseDouble) {
		
	}
	
}
