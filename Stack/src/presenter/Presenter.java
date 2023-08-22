package presenter;

import model.FunctionStack;
import view.View;

/**
 *
 * @author Sebastian Zarate
 */
public class Presenter {

    View view = new View();
    FunctionStack function = new FunctionStack();

    public void run() {
        String expression = view.readData("Ingrese la expresión a evaluar");
        double result = function.evaluateExpression(expression);
        view.showMessage("El resultado de la expresión es: " + result);
    }

    public static void main(String[] args) {
        new Presenter().run();
    }
}
