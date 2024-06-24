import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueCalculating = true;

        while (continueCalculating) {
            try {
                // Taking user input for two numbers and operator
                System.out.print("Enter first number: ");
                double num1 = scanner.nextDouble();

                System.out.print("Enter second number: ");
                double num2 = scanner.nextDouble();

                System.out.print("Enter operator (+, -, *, /): ");
                char operator = scanner.next().charAt(0);

                // Performing calculation based on operator
                double output = calculate(num1, num2, operator);
                System.out.println("Result: " + num1 + " " + operator + " " + num2 + " = " + output);

                // Ask user if they want to continue
                System.out.print("Do you want to calculate again? (yes/no): ");
                String choice = scanner.next().toLowerCase();
                if (!choice.equals("yes")) {
                    continueCalculating = false;
                    System.out.println("Calculator has been closed.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // clear the input buffer
            } catch (ArithmeticException e) {
                System.out.println("Error: Division by zero");
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }

        scanner.close();
    }

    public static double calculate(double num1, double num2, char operator) {
        double output = 0;
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
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
        return output;
    }
}

