package Translation;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class TranslationController {
	@FXML
	Label xLabel;
	@FXML
	Label yLabel;
	@FXML
	Slider xSlider;
	@FXML
	Slider ySlider;
	@FXML
	TextField xText;
	@FXML
	TextField yText;
	
	public void xSliderChanging(MouseEvent e) {
		try {
			xLabel.setText(String.format("%.2f", xSlider.getValue()));
			xText.setText(xLabel.getText());
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}
	public void ySliderChanging(MouseEvent e) {
		try {
			yLabel.setText(String.format("%.2f", ySlider.getValue()));
			yText.setText(yLabel.getText());
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}
	public void xTextSet(KeyEvent e) {
		if (e.getCode().equals(KeyCode.ENTER)) {
			try {
				Double.parseDouble(xText.getText());
				xSlider.setValue(Double.parseDouble(xText.getText()));
				xLabel.setText(xText.getText());
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	public void yTextSet(KeyEvent e) {
		if (e.getCode().equals(KeyCode.ENTER)) {
			try {
				Double.parseDouble(yText.getText());
				ySlider.setValue(Double.parseDouble(yText.getText()));
				yLabel.setText(yText.getText());
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	public void confirm(ActionEvent e) {
		Main.newTranslation(Double.parseDouble(xLabel.getText()), Double.parseDouble(yLabel.getText()));
	}
}
