package application;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.ws.handler.MessageContext.Scope;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import transforms.Composition;
import transforms.IComposition;
import transforms.LibraryException;
import transforms.elementaires.Rotation;
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
   private ArrayList<Boolean> display;
   private int iLast = 0;

   public void initialize() throws LibraryException {
        /*
        Construction de la composition
         */
		   
	    composition = new Composition();
	    listView1.getItems().add("Maison");
	    
	    display = new ArrayList<>();
	    display.add(true);
	    allNodes = composition.draw(display);
	    
	    allNodes.get(iLast).setOnMouseReleased(new TranslationHandler());
	    allNodes.get(iLast).setOnScroll(new RotationHandler());
        
        pane.getChildren().addAll(allNodes);
        
        
        composition.setZoom(35, pane.getPrefWidth()/2+400, pane.getPrefHeight()/2+200);
        pane.setPickOnBounds(false);
        pane.getChildren().add(composition.getGrille(pane));
    }
   
   private void addTranslation(double x, double y) {
	   composition.add(new Translation(x, y));
	   display.add(true);
	   try {
		   allNodes.add(composition.draw(display).get(allNodes.size()));
	   } catch (LibraryException e1) {
		   // TODO Auto-generated catch block
		   e1.printStackTrace();
	   }
	   pane.getChildren().add(allNodes.get(allNodes.size()-1));
   }
   
   private void addRotation(double angle, double x, double y) {
	   composition.add(new Rotation(angle, x, y));
	   display.add(true);
	   try {
		   allNodes.add(composition.draw(display).get(allNodes.size()));
	   } catch (LibraryException e1) {
		   // TODO Auto-generated catch block
		   e1.printStackTrace();
	   }
	   pane.getChildren().add(allNodes.get(allNodes.size()-1));
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
	
	public void setCurrent() {
		allNodes.get(iLast).setOnScroll(null);
		allNodes.get(iLast).setOnMouseReleased(null);
		iLast++;
		allNodes.get(iLast).setOnScroll(new RotationHandler());
		allNodes.get(iLast).setOnMouseReleased(new TranslationHandler());
	}
	
	public class RotationHandler implements EventHandler<ScrollEvent>{
		@Override
		public void handle(ScrollEvent e) {
			addRotation(e.getDeltaY(), 0,0);
			listView2.getItems().add("Rotation : "+Math.abs(e.getDeltaY()%360));
			setCurrent();
		}
	}
	
	public class TranslationHandler implements EventHandler<MouseEvent>{
		@Override
		public void handle(MouseEvent e) {
			System.out.println(composition.xMouseToMath(e.getSceneX()) + " - " + composition.yMouseToMath(e.getSceneY()));
			addTranslation(composition.xMouseToMath(e.getSceneX())-7, composition.yMouseToMath(e.getSceneY()));
			listView2.getItems().add("Translation : "+composition.xMouseToMath(e.getSceneX()) + " - " + composition.yMouseToMath(e.getSceneY()));
			setCurrent();
		}
	}
}
