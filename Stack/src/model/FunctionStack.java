package model;

import java.util.Stack;

/**
 *
 * @author Sebastian Zarate
 */
public class FunctionStack {

    // Función para evaluar una expresión dada
    public double evaluateExpression(String expression) {
        
        Stack<Double> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();
        
        for (int i = 0; i < expression.length(); i++) {
            char character = expression.charAt(i);
            if (Character.isDigit(character) || character == '.') {
                StringBuilder numberStr = new StringBuilder();
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    numberStr.append(expression.charAt(i));
                    i++;
                }
                i--;
                double number = Double.parseDouble(numberStr.toString());
                numbers.push(number);
            } else if (character == '(') {
                operators.push(character);
            } else if (character == ')') {
                while (operators.peek() != '(') {
                    applyOperator(operators.pop(), numbers);
                }
                operators.pop();
            } else if (isOperator(character)) {
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(character)) {
                    applyOperator(operators.pop(), numbers);
                }
                operators.push(character);
            } else if (Character.isLetter(character)) {
                StringBuilder functionStr = new StringBuilder();
                while (i < expression.length() && Character.isLetter(expression.charAt(i))) {
                    functionStr.append(expression.charAt(i));
                    i++;
                }
                i--;
                String function = functionStr.toString();
                if (function.equals("sin")) {
                    operators.push('s');
                } else if (function.equals("cos")) {
                    operators.push('c');
                }
            }
        }
        
        while (!operators.isEmpty()) {
            applyOperator(operators.pop(), numbers);
        }
        
        return numbers.pop();
    }
    
    public double applyOperator(char operator, Stack<Double> numbers) {
        double result = 0;
        if (operator == 's') {
            result = Math.sin(Math.toRadians(numbers.pop()));
        } else if (operator == 'c') {
            result = Math.cos(Math.toRadians(numbers.pop()));
        } else {
            double b = numbers.pop();
            double a = numbers.pop();
            switch (operator) {
                case '+':
                    result = a + b;
                    break;
                case '-':
                    result = a - b;
                    break;
                case '*':
                    result = a * b;
                    break;
                case '/':
                    if (b == 0) {
                        throw new ArithmeticException("División por cero");
                    }
                    result = a / b;
                    break;
            }
        }
        return numbers.push(result);
    }

    // Función para verificar si un carácter es un operador
    public static boolean isOperator(char character) {
        return character == '+' || character == '-' || character == '*' || character == '/' || character == 's' || character == 'c';
    }

    // Función para obtener la precedence de un operador
    public static int precedence(char operator) {
        if (operator == '+' || operator == '-') {
            return 1;
        }
        if (operator == '*' || operator == '/') {
            return 2;
        }
        if (operator == 's' || operator == 'c') {
            return 3;
        }
        return 0;
    }
    
}
