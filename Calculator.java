import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input for two numbers and operator
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

        System.out.print("Enter operator (+, -, *, /): ");
        char operator = scanner.next().charAt(0);

        // Performing calculation based on operator
        double output = calculate(num1, num2, operator);
        System.out.println("Output: " + output);
    }

    public static double calculate(double num1, double num2, char operator) {
        double output = 0;
        try {
            switch (operator) {
                case '+':
                    output = num1 + num2;
                    break;
                case '-':
                    output = num1 - num2;
                    break;
                case '*':
                    output = num1 * num2;
                    break;
                case '/':
                    if (num2 == 0) {
                        throw new ArithmeticException("Division by zero");
                    }
                    output = num1 / num2;
                    break;
                default:
                    System.out.println("Invalid operator");
            }
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero");
            output= 0; // function returns 0 when division by zero occurs.

        }
        return output;
    }
}
