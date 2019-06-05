package application;

public class Model {

	public double calculate(double firstOperand, double secondOperand, String operator) {

		double ans = 0;

		switch (operator) {
		case "+":
			return Double.valueOf(firstOperand + secondOperand);

		case "-":
			return Double.valueOf(firstOperand - secondOperand);

		case "×":
			return firstOperand * secondOperand;

		case "÷":
			try {
				return firstOperand / secondOperand;
			} catch (Exception e) {
				MainController myCont = new MainController();
				myCont.setErrorText();
				return Double.valueOf(0);
				
			}
		}
		return ans;
	}

}
