package translation;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
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
			xLabel.setText(format(String.format("%.2f", xSlider.getValue())));
			xText.setText(format(xLabel.getText()));
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}
	public void ySliderChanging(MouseEvent e) {
		try {
			yLabel.setText(format(String.format("%.2f", ySlider.getValue())));
			yText.setText(format(yLabel.getText()));
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}
	public void xTextSet(KeyEvent e) {
			try {
				Double.parseDouble(xText.getText());
				xSlider.setValue(Double.parseDouble(xText.getText()));
				xLabel.setText(format(xText.getText()));
			} catch (Exception e2) {
				// TODO: handle exception
			}
	}
	public void yTextSet(KeyEvent e) {
			try {
				Double.parseDouble(yText.getText());
				ySlider.setValue(Double.parseDouble(yText.getText()));
				yLabel.setText(format(yText.getText()));
			} catch (Exception e2) {
				// TODO: handle exception
			}
	}
	private String format(String string) {
		return string.replace(",", ".");
	}
	public void confirm(ActionEvent e) {
		Main.getController().addTranslation(Double.parseDouble(xLabel.getText()), Double.parseDouble(yLabel.getText()));
		Main.closeAll();
	}
}
