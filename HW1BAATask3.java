// Реализовать простой калькулятор
package Homework;

import java.math.RoundingMode;
import java.util.Scanner;

public class HW1BAATask3 {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);

        Double number1 = getDouble(iScanner, "Please, input a first number: ");
        iScanner.nextLine();
        System.out.println("Please, input a symbol of operation +, -, / or *: ");
        String operation = iScanner.nextLine().trim();
        Double number2 = getDouble(iScanner, "Please, input a second number: ");
        Double result = 0D;
        switch (operation) {
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "*":
                result = number1 * number2;
                break;
            case "/":
                result = (number1 / number2);
                break;
        default:
        System.out.println("Wrong operation");
                break;
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("Your result is: " + number1 + " " + operation + " " + number2 + " = " + result);
        System.out.println(sb);
        iScanner.close();
    }

    private static Double getDouble(Scanner scanner, String message) {
        System.out.println(message);
        Double num = scanner.nextDouble();
        return num;
    }

    
}
