//[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},
//{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
//{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
// Написать метод(ы), который парсит json и, используя StringBuilger, создаст стpоки вида: 
// Студент [фамилия] получил [оценка] по предмету [математика]
//Студент Иванов получил 5 по предмету Математика.
//Студент Петрова получил 4 по предмету Информатика.
//Студент Краснов получил 5 по предмету Физика.
package Homework.HW2;
import java.util.Arrays;
public class HW2BAATask3 {
    
    public static String parseJson(String data) {
        StringBuilder sb1 = new StringBuilder();
        data = data.replace(":",",");
        String[] parts = data.split(",");
        
        for (int i = 0; i < parts.length; i++) {
            parts[i] = parts[i].replace("{"," ").replace("}","")
            .replace("["," ").replace("]","").replace("\"","")
            .replace("фамилия","Студент").replace("оценка","получил ")
            .replace("предмет","по предмету").trim();

            if (i> 0 && (i+1)%6==0) sb1.append(parts[i]).append(".\n");
            else sb1.append(parts[i]).append(" ");
        }
        return sb1.toString(); 
    }
    public static void main(String[] args) {
        String str = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"},\n{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"},\n{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";
        System.out.println(str);
        System.out.println(parseJson(str));
    }
}
