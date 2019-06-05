package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MainController {

	private Model model = new Model();
	private String operator = "";
	private double firstOperand = 0f;
	private boolean start = true;
	@FXML
	private TextField display;

	@FXML
	private Button one;

	@FXML
	private Button two;

	@FXML
	private Button three;

	@FXML
	private Button minus;

	@FXML
	private Button four;

	@FXML
	private Button five;

	@FXML
	private Button six;

	@FXML
	private Button multi;

	@FXML
	private Button seven;

	@FXML
	private Button eight;

	@FXML
	private Button nine;

	@FXML
	private Button division;

	@FXML
	private Button zero;

	@FXML
	private Button equal;

	@FXML
	private Button plus;

	@FXML
	private Button point;

	@FXML
	private Button accumulator;

	@FXML
	private Button cdelete;

	@FXML
	private Button percent;

	@FXML
	private Button plusminus;

	public MainController() {

	}

// methods
	public void setEmptyText() {
		display.setText("");
	}

	public void setErrorText() {
		display.setText("Error");
	}

	@FXML
	void handleButtonAction(ActionEvent event) {
		if (start) {
			setEmptyText();
			start = false;
		}

		if (event.getSource() == accumulator) {
			setEmptyText();
		} else if (event.getSource() == cdelete) {
			if (!display.getText().isEmpty()) {
				display.setText(display.getText().substring(0, display.getText().length() - 1));
			}
		} else if (event.getSource() == plusminus) {
			if (!display.getText().isEmpty()) {
				Float value = Float.parseFloat(display.getText());

				value = value * (-1);
				display.setText(Float.toString(value));
			}
		} else {
			String value = ((Button) event.getSource()).getText();
			display.setText(display.getText() + value);
		}

	}

	@FXML
	void processOperators(ActionEvent event) {
		String value = ((Button) event.getSource()).getText();

		if (!"=".equals(value)) {
			if (!operator.isEmpty())
				return;

			operator = value;
			firstOperand = Double.parseDouble(display.getText());
			setEmptyText();
		} else {
			if (operator.isEmpty())
				return;

			display.setText(
					String.valueOf(model.calculate(firstOperand, Double.parseDouble(display.getText()), operator)));
			operator = "";
			start = true;
		}
	}

}
