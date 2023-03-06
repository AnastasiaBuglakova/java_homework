// Вычислить n-ое треугольного число(сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
package Homework;

import java.util.Scanner;

public class HW1BAATask1 {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Please, input a number: ");
        int number = iScanner.nextInt();
        int triangleNumber = 0;
        for (int index = 1; index <= number; index++) {
            triangleNumber += index;
        }
        System.out.printf("Triangle number = %d\n", triangleNumber);

        iScanner.close();
    }
}
