package Homework;

import java.util.Arrays;
import java.util.Scanner;

// *+Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть заменены знаком вопроса, 
// например 2? + ?5 = 69. Требуется восстановить выражение до верного равенства. 
// Предложить хотя бы одно решение или сообщить, что его нет.
public class HW1BAATask4 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Please, input a equation inform q? + ?w = e: ");
        String equation = iScanner.nextLine();
        System.out.println(equation);
        String[] parts = equation.replace("=", "?").split("\\?");
        System.out.println(Arrays.toString(parts));
        for (int index = 0; index < parts.length; index++) {
            parts[index] = parts[index].trim();
        }
        StringBuilder sb = new StringBuilder();
        
        int res = Integer.parseInt(parts[3]) - Integer.parseInt(parts[2]) - Integer.parseInt(parts[0])*10;
        System.out.println(res);
        if (res >= 0){
            sb.append("One of the solutions:");
            sb.append(parts[0]);
            sb.append(res%10).append(" + ");
            sb.append(res/10).append(parts[2]).append(" = ");
            
            sb.append(parts[3]);
        } else {
            sb.append("this equation has no solutions");
        }
        System.out.println(sb);
        iScanner.close();
    }
}
