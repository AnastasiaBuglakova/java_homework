// 2. Реализуйте алгоритм сортировки пузырьком числового массива, 
//результат после каждой итерации запишите в лог-файл.
package Homework.HW2;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.*;
import java.util.Arrays;

public class HW2BAATask2 {
    public static void main(String[] args) throws IOException {
        
        Logger logger = Logger.getLogger(HW2BAATask2.class.getName());
        logger.setLevel(Level.WARNING);
        FileHandler fh = new FileHandler("HW2/logHW.txt");
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);

        logger.warning("Пошаговое логирование пузырьковой сортировки\n");
        // level warning задаю для разнообразия, это, конечно, info
        int[] arr = {2, 10, 7, 9, 1, 2, 5, 0, 4};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-1; j++) {
                if (arr[j]> arr[j+1]){
                    int help = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = help;
                    // добавляем запись в лог только при перестановке
                    logger.info("\ni = " + Integer.toString(i) + "; j = " + Integer.toString(j) + " " + Arrays.toString(arr));
                }
            }
        }
    }
}
