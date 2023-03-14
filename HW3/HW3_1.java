//  Реализовать алгоритм сортировки слиянием
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class HW3_1 {

    public static void main(String[] args) {
        int[] array = new int[] {222,9,7,0,5,4,66};
        System.out.println(Arrays.toString(array));
        ArrayList aL = mergeSort(array);
        System.out.println(aL);
    }

    public static ArrayList mergeSort(int[] array) {
        ArrayList<Integer> currentArr = new ArrayList<>();
        for (int index = 0; index < array.length; index++) {
            currentArr.add(array[index]);
        }

        int size = 1;
        while (size < currentArr.size()) {
            int leng = currentArr.size();
            System.out.println(size);
            for (int index = 0; index < currentArr.size() || leng >0; index+=size*2) {
                
                int start1 = index;
                int stop1 = Math.min(leng+start1,index+size);
                leng -= stop1 - start1;
                
                int start2 = -1;
                int stop2 = -1;
                if (leng>0){
                    start2 = stop1;
                    stop2 = Math.min(leng+start2,start2+size);
                    leng -= stop2 - start2;
                    
                } else { 
                    start2 = 0;
                    stop2 = 0;
                    leng = 0;
                }
                // System.out.printf("start1 %d, stop1 %d, start2 %d, stop2 %d, len  %d", start1 , stop1, start2,stop2, leng);
                System.out.println(currentArr.subList(start1, stop1));
                if (start2 !=0 && stop2!=0) {
                    ArrayList<Integer> newArr = new ArrayList<>();
                    System.out.printf("сливаем текущий и новый массивы");
                    newArr = merge(start1, stop1, start2, stop2, currentArr);
                    for (int j = 0; j < newArr.size(); j++) {
                        currentArr.set(j+start1,newArr.get(j)); 
                    }
                }
                
            }
            size = size*2;
    }
        return currentArr;
}

    public static ArrayList merge(int start1, int stop1, int start2, int stop2, ArrayList currentArr) {
        ArrayList<Integer> destArr = new ArrayList<>();
        ArrayList<Integer> arr1 = new ArrayList<>(currentArr.subList(start1, stop1));
        ArrayList<Integer> arr2 = new ArrayList<>(currentArr.subList(start2, stop2));   
        
        int count = arr1.size() + arr2.size();
        while (count>0){
  
            if (arr1.isEmpty()|| arr2.isEmpty()){
                if (arr1.isEmpty()) {
                    destArr.add(arr2.remove(0));
        
                } else {
                    destArr.add(arr1.get(0));
                    arr1.remove(0);
                
                }
            } else {
                if (arr1.get(0) > arr2.get(0)){
                    destArr.add(arr2.get(0));
                    arr2.remove(0);
                    
                } else {
                    destArr.add(arr1.get(0));
                    arr1.remove(0);
    
                }
            }
            System.out.println(destArr);
            System.out.println();
            count--;
        }
        return destArr;
    }
}
