// Реализуйте очередь с помощью LinkedList со следующими методами:
// • enqueue() — помещает элемент в конец очереди,
// • dequeue() — возвращает первый элемент из очереди и удаляет его,
// • first() — возвращает первый элемент из очереди, не удаляя.
import java.util.LinkedList;
import java.util.Queue;

public class HW4_2 {
    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedList<>();
      
        ll.add("ee"); ll.add("dd"); ll.add("aa"); ll.add("vc");

        System.out.println(ll);
        enqueue(ll,"ggggg");
        System.out.println(ll);
        System.out.println(dequeue(ll));
        System.out.println(ll);
        System.out.println(first(ll));
        System.out.println(ll);
    }
    // помещает элемент в конец очереди
    public static void enqueue(LinkedList <String>ll, String str){
        ll.add(str);
        System.out.println(ll);
    }
    // возвращает первый элемент из очереди и удаляет его
    public static String dequeue(LinkedList <String>ll){
       
        String item = ll.removeFirst();

        return item;
    }
    // возвращает первый элемент из очереди, не удаляя.
    public static String first(LinkedList <String>ll){
        return ll.get(0);
    }
}
        // Queue<Integer> queue = new LinkedList<Integer>();
        // queue.add(1);
        // queue.add(2);
        // queue.add(3);
        // queue.add(4);
        // System.out.println(queue); // [1, 2, 3, 4]
        // int item = queue.remove();
        // // System.out.println(queue.remove());
        // System.out.println(queue); // [2, 3, 4]
        // queue.offer(2809);
        // item = queue.remove();
        // System.out.println(queue); // [3, 4, 2809]
        // item = queue.remove();
        // System.out.println(queue); // [4, 2809]
        // item = queue.remove();
        // System.out.println(queue); // [2809]
        // System.out.println(queue.peek());