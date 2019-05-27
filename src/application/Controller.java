package application;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import transforms.Composition;
import transforms.IComposition;
import transforms.LibraryException;
import transforms.elementaires.Translation;
import transforms.mobile.Maison;

public class Controller {
	@FXML
	private CheckBox cbGrille;
	
	@FXML
	private CheckBox cbTrace;
	
	@FXML
	private MenuItem saveItem;
	
	
	@FXML
	private VBox vBox;
	
	@FXML
	private Slider sliderAnimation;
	
	@FXML
	private Button btPlay;
	
	@FXML
	private ListView<String> listView1;
	
	@FXML
	private ListView<String> listView2;
	
	@FXML
	private MenuBar menu;
	
	@FXML
	private Pane pane;

   private IComposition composition;
   private List<Node> allNodes;

   public void initialize() throws LibraryException {
        /*
        Construction de la composition
         */
        composition = new Composition();

        ArrayList<Boolean> display = new ArrayList<>(
                Arrays.asList(true)                 // Affichage des états 0 (initial), 1 et 3
        );
        allNodes = composition.draw(display);
        allNodes.get(0).setOnMouseReleased(e -> {
        	composition.add(new Translation(e.getSceneX(), e.getSceneY()));
        });
        
        pane.getChildren().addAll(allNodes);
        
        
        composition.setZoom(35, pane.getPrefWidth()/2+400, pane.getPrefHeight()/2+200);
        pane.setPickOnBounds(false);
        pane.getChildren().add(composition.getGrille(pane));
    }

	public void save() {
		
	}
	
	public void switchGrille() {
		
	}
	
	public void switchTrace() {

	}
	
	public void cursorAnimationChange() {
		
	}
	
	public void playAnimation() {
		
	}
	
	
	
	
	
}
