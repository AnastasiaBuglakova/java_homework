// 1 Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернёт «перевёрнутый» список.
package HW4;
import java.util.LinkedList;
import java.util.Scanner;

public class HW4_1 {
    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedList<>();
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Введите число элементов массива: ");
        int size = iScanner.nextInt();
        iScanner.nextLine();
        String current = null;
        for (int index = 0; index < size; index++) {
            System.out.println();
            System.out.printf("Введите элемент массива %d: ", index);
            current = (iScanner.nextLine());
            ll.add(current);
            System.out.println();
        }
        
        System.out.printf("Получился массив: ");
        System.out.println(ll);
        System.out.printf("Перевернули и вот\n");
        System.out.println(reverse(ll, size));
        iScanner.close();
    }

    public static LinkedList<String> reverse(LinkedList<String> ll, int size) {
        
        LinkedList<String> revLl = new LinkedList<>();
        while(size > 0)  {
            revLl.addLast(ll.removeLast());
            size--;
        }
        return revLl;
    }
    
}
