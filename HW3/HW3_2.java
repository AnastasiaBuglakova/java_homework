import java.util.ArrayList;
import java.util.Arrays;

// Пусть дан произвольный список целых чисел, удалить из него чётные числа
public class HW3_2 {
    public static void main(String[] args) {
        int[] list = {3,5,0, 9, 4, 22, 1, 8};
        ArrayList<Integer> newList = new ArrayList <Integer>();
        for (int index = 0; index < list.length; index++) {
            if (list[index]%2 == 0)
                newList.add(list[index]);
        }
        System.out.println(newList);
    }
}
