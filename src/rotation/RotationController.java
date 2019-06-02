package rotation;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class RotationController {
	@FXML
	private Label label;
	@FXML
	private Slider slider;
	@FXML
	private TextField textField;
	public void onEnter(KeyEvent e) {
		if (e.getCode().equals(KeyCode.ENTER)) {
			try {
				Double.parseDouble(textField.getText());
				slider.setValue(Double.parseDouble(textField.getText()));
				label.setText(format(label.getText()));
			} catch (Exception e2) {
				// TODO: handle exception
			}
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
	public void confirm(ActionEvent e) {
		Main.newRotation(Double.parseDouble(label.getText()));
	}
}
