package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import transforms.elementaires.Rotation;
import transforms.elementaires.Translation;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	
	private static Controller controller;
	private static Stage mainStage;
	
	@Override
	public void start(Stage stage) throws IOException {
		mainStage = stage;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("interface.fxml"));
        Parent root = loader.load();
        controller = loader.getController();

        Scene scene = new Scene(root);
        
        mainStage.setWidth(Double.MAX_VALUE);
        mainStage.setHeight(Double.MAX_VALUE);
        mainStage.setScene(scene);
        
        mainStage.setTitle("IGraphics");
        mainStage.show();
}

	public static void main(String[] args) {
	        Application.launch(args);
	}
	
	public static Controller getController() {
		return controller;
	}

	public static void newTranslation(double parseDouble, double parseDouble2) {
		getController().getComposition().add(new Translation(parseDouble, parseDouble2));
	}

	public static void newRotation(double parseDouble) {
		getController().getComposition().add(new Rotation(parseDouble, 1, 1));
	}

	public static Stage getMainStage() {
		return mainStage;
	}

	public static void closeAll() {
		for (Stage elt :  getController().getStages()) {
			elt.close();
		}
	}
}
