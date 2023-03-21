import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.List;
import java.util.SortedMap;

// 2 Пусть дан список сотрудников:
// Иван Иванов
// Светлана Петрова
// Кристина Белова
// Анна Мусина
// Анна Крутова
// Иван Юрин
// Петр Лыков
// Павел Чернов
// Петр Чернышов
// Мария Федорова
// Марина Светлова
// Мария Савина
// Мария Рыкова
// Марина Лугова
// Анна Владимирова
// Иван Мечников
// Петр Петин
// Иван Ежов
// Написать программу, которая найдёт и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности.


public class HW5_2 {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
                    try {
                        List<String> allLines = Files.readAllLines(Paths.get("names.txt"));
                        for (String line : allLines) {
                            System.out.println(line);
                            String[] arr = line.split(" ");
                            map.put(arr[1].trim(),arr[0].trim());
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

            HashMap<String, Integer> popularity = new HashMap<>();
            Integer max = 0;
            for (java.util.Map.Entry<String, String> pair: map.entrySet()) {
                System.out.printf("%s = %s\n", pair.getKey(), pair.getValue());
                
                if (popularity.containsKey(pair.getValue())){
                    Integer newValue = (popularity.get(pair.getValue()))+1;
                    popularity.put(pair.getValue(), newValue );
                    if (max < newValue) max = newValue;
                }else{
                    popularity.put(pair.getValue(),1);
                    if (max < 1) max = 1;
                }
                }
                for (java.util.Map.Entry<String, Integer> pair: popularity.entrySet()) {
                    System.out.printf("Имя %s => количество повторов %s\n", pair.getKey(), pair.getValue());
                }

                String a = null;
                System.out.println("сортируем");
                for (int index = max; index > 0; index--) {
                    if (popularity.containsValue(max)) {
                        for (java.util.Map.Entry<String, Integer> name : popularity.entrySet()) {
                            if (name.getValue() == index) {
                                a = name.getKey();
                                System.out.printf("%s  => \n", a);
                                for (java.util.Map.Entry<String, String> lastName : map.entrySet()) {
                                    if (lastName.getValue().equals(a)) System.out.println(lastName.getKey());
                                }    
                            }
                        }
                }
                }
                    
}


    }

