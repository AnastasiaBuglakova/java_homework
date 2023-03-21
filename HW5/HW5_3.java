import java.io.IOException;
import java.util.Arrays;
// Реализовать алгоритм пирамидальной сортировки (HeapSort).

public class HW5_3 {
    public static void main(String[] args) throws IOException {
        Integer[] arr = {14, 61, 85, 24, 74, 26, 17, 50, 40,45, 21, 32, 59, 58, 13};
        
        // заводим цикл, в котором будем по мере сортировки уменьшать сортируемую длину
        for (int l = arr.length; l > 1; l--) {
            int level = 0;
            int temp = arr.length;
            // считаем уровень левел на котором будем вызывать сортировку
            for (int index = 1; temp > 1; index++) {
                temp = temp/2;
                level=index;
            }
        
            // последовательно отправляем все уровни для сортировки в метод хип
            for (int j = level; j > 0; j--) {
                System.out.println(level);
                System.out.println(l);
                
                heap(j, l, arr);
                int temp2 = arr[0];
                arr[0] = arr[l-1];
                arr[l-1] = temp2;
                level--;
            }
        }
        
    }
    public static Integer[] heap(int level,int len, Integer[] array){
        // ищем позицию первого родителя
        
        int parentPos = (int) Math.pow(2, level-1)-1;
        int set = (int) Math.pow(2, level-1);
        for (int index = 0; index < set; index++) {
            
            System.out.print("\nParent pos = ");
            System.out.println(parentPos);
            // ищем позиции детей
            System.out.println(level);
            int a = (int) Math.pow(2, level) - 1 + 2* index;
            // System.out.println(a);
            int child1;
            if (a+1<len) {
                child1 = array[a];
                int child2 = array[a+1];   
                // System.out.printf("child1 %s + child2 %s",child1, child2);
                if (array[parentPos] < child1) {
                    int help = array[parentPos];
                    array[parentPos] = child1;
                    array[a] =help;
                }
                if (array[parentPos] < child2) {
                    int help = array[parentPos];
                    array[parentPos] = child2;
                    array[a+1] =help;
                }
            } else {
                if (a<len) {
                    child1 = array[a];
                    if (array[parentPos] < child1) {
                        int help = array[parentPos];
                        array[parentPos] = child1;
                        array[a] =help;
                    }
                }
            }
                parentPos++;
        }
        
        System.out.println(Arrays.toString(array));
        return array;
    }
    
    
}
