package rotation;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class RotationController {
	@FXML
	private Label label;
	@FXML
	private Slider slider;
	@FXML
	private TextField textField;
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
	
	public void onEnter(KeyEvent e) {
			try {
				Double.parseDouble(textField.getText());
				slider.setValue(Double.parseDouble(textField.getText()));
				label.setText(format(label.getText()));
			} catch (Exception e2) {
				// TODO: handle exception
			}
	}
	public void onChange(MouseEvent e) {
		try {
			label.setText(format(String.format("%.2f", slider.getValue())));
			textField.setText(format(label.getText()));
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}
	
	private String format(String string) {
		return string.replace(",", ".");
	}
	
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
	
	public void confirm(ActionEvent e) {
		Main.getController().addRotation(Double.parseDouble(label.getText()), Double.parseDouble(xLabel.getText()), Double.parseDouble(yLabel.getText()));
		Main.closeAll();
	}
}
