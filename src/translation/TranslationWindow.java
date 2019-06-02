package translation;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TranslationWindow extends Stage {
		public TranslationWindow(Stage primary) throws IOException {
			this.initModality(Modality.APPLICATION_MODAL);
			this.initOwner(primary);
			this.setResizable(false);
			FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(getClass().getResource("TranslationView.fxml"));
	        Parent root = loader.load();
	        Scene scene = new Scene(root);
			
			setScene(scene);
	        setTitle("Translation");
	        show();
		}
}
