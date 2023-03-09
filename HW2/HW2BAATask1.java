// 1. Дана строка sql-запроса 'select * from students where '. 
//Сформируйте часть where этого запроса, используя StringBuilger. Данные для 
// фильтрации приведены ниже в виде json строки. Если значение null, то параметр не должен 
//попадать в запрос.
//Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
// select * from students where name = 'Ivanov' and country = 'Russia' and city = 'Moscow'
package Homework.HW2;

import java.util.Arrays;

public class HW2BAATask1 {
    public static void main(String[] args) {
        String jsonData = "\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"";
        System.out.println(jsonData);
        StringBuilder sb = new StringBuilder();
        String[] parts = jsonData.replace("\"", "").replace(":", ",").trim().split(",");
        System.out.println(Arrays.toString(parts));
        sb.append("select * from students where ");
        for (int index = 0; index < parts.length; index+=2) {
            sb.append(parts[index]).append(" = \'").append(parts[index+1]).append("\'");
            if (index < parts.length-2) sb.append(" and ");
        }
        System.out.println(sb);

        

        
    }
}
