import java.util.HashMap;

// На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.
public class HW5_4 {
    public static void main(String[] args) {
        HashMap <Integer, Integer> ferzi = new HashMap<>();
        int[] arr[] = new int [8][8];
        int n = 8;
        int gor = 0;
        int vert = 4;
        n--;
        arr[gor][vert]=1;
        ferzi.put(gor, vert);
        arr=fillLines(gor, vert, arr);
        
        
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ( arr[i][j] == 0) {
                    arr = fillLines(i, j, arr);
                    ferzi.put(i, j);
                n--;
                }
            }
            for (int[] line : arr) {
                for (int item : line) System.out.printf("%d ", item);
            System.out.println();}
    
            System.out.println("Ферзи на позициях:");
            for (java.util.Map.Entry<Integer, Integer> item : ferzi.entrySet()) {
                System.out.printf("[%d : %d]\n", item.getKey(), item.getValue());
            }
            System.out.printf("Ферзей осталось %d\n", n);
        }
        for (int[] line : arr) {
            for (int item : line) System.out.printf("%d ", item);
        System.out.println();}

        System.out.println("Ферзи на позициях:");
        for (java.util.Map.Entry<Integer, Integer> item : ferzi.entrySet()) {
            System.out.printf("[%d : %d]\n", item.getKey(), item.getValue());
        }
        System.out.printf("Ферзей осталось %d\n", n);
        System.out.println("Ферзи на позициях 8:");
        for (java.util.Map.Entry<Integer, Integer> item : ferzi.entrySet()) {
            arr[item.getKey()][item.getValue()] = 8;
        }
        for (int[] line : arr) {
            for (int item : line) System.out.printf("%d ", item);
        System.out.println();}
    }

    public static int[][] fillLines(int gor, int vert, int[] arr[] ) {
        // заполняем по горизонтали
        for (int i = 0; i < 8; i++) {
            arr[i][vert]=1;
        }
        // заполняем по вертикали
        for (int j = 0; j < 8; j++) {
            arr[gor][j]=1;
        }
        // заполняем по диагонали 1 i++ j++
        for (int i = gor+1, j = vert+1; i < 8 && j < 8; i++,j++) {
            arr[i][j]=1;
        }
        for (int i = gor-1, j = vert-1; i >=0 && j >=0; i--,j--) {
            arr[j][i]=1;
        }
        // заполняем по диагонали 1 i+j=const
        // int c = gor + vert;
        for (int i = gor+1, j = vert-1; i < 8 && j >= 0; i++,j--) {
            arr[i][j]=1;
        }
        for (int i = gor-1, j = vert+1; i >= 0 && j < 8; i--,j++) {
            arr[i][j]=1;
        }
        return arr;
    }
    
   
    
    
}
