import java.util.ArrayList;
import java.util.Arrays;

// Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.

public class HW3_3 {
    public static void main(String[] args) {
        int[] li = {3, 5, 0, 9, 4, 22, 1, 8};
        ArrayList <Integer> l = new ArrayList<>();
        
        for (int index = 0; index < li.length; index++) {
            l.add(li[index]);
        }
        
        int min = (l.get(0));
        int max = (l.get(0));
        int average =(l.get(0));
        
        for (int index = 1; index < l.size(); index++) {
            if (min > (l.get(index))) min = (l.get(index));
            if (max < l.get(index)) max = l.get(index);
            average += l.get(index);
            System.out.println(average);
        }
        
        Double ave = (double) average;
        Double dSize = (double) l.size();
        ave = ave/dSize;
        System.out.printf("min = %d, average = %f, max = %d\n",min, ave, max);

        
    }

}
