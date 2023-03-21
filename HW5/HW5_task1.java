import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

// Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.

public class HW5_task1 {
    public static void main(String[] args) throws IOException {
        HashMap<String, String> telephoneDirectory = new HashMap<>();
        Scanner iSc = new Scanner(System.in);
        Boolean exit = false;
        String action = "n";
        String[] msg = {"00 Please, input a phone number: ", 
                        "01 Please, input a name:",
                        "02 Please, input a second number:", "\n03 Input a number or name to delete \n", 
                        "04 Wrong number format", "05 ",
                        "06 Hello, \nfor open a phonebook -> \"v\",\nto delete a contact -> \"d\", \nfor enering of a new conact enter -> \"n\", \nfor exit choose \"e\""};
        try {
                            List<String> allLines = Files.readAllLines(Paths.get("phonebook.txt"));
                            for (String line : allLines) {
                                System.out.println(line);
                                String[]arr = line.split("\t");
                                telephoneDirectory.put(arr[0], arr[1]);

                            }
        } catch (IOException e) {
                            e.printStackTrace();
                        }

        while (!exit){
            System.out.println(msg[6]);
            action = iSc.nextLine().toLowerCase();
            switch (action) {
                case "v":
                    try {
                        List<String> allLines = Files.readAllLines(Paths.get("phonebook.txt"));
                        for (String line : allLines) {
                            System.out.println(line);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    for (Entry <String, String> pair: telephoneDirectory.entrySet()) {
                        System.out.printf("%s = %s\n", pair.getKey(), pair.getValue());
                    }
                    break;

                case "n":        
                    System.out.println(msg[0]);
                    String currentStrKey = iSc.nextLine();
                    System.out.println(msg[1]);
                    String currentStrValue = iSc.nextLine();

                    telephoneDirectory.put(currentStrKey,currentStrValue);
                    try (FileWriter fw = new FileWriter ("phonebook.txt", true)){
                        fw.append(currentStrKey);
                        fw.append("\t");
                        fw.append(currentStrValue);
                        fw.append("\n");
                        fw.flush();
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "d":
                    System.out.println("STEP1");
                        try {
                            List<String> allLines = Files.readAllLines(Paths.get("phonebook.txt"));
                            for (String line : allLines) {
                                String[] str = line.split("\t");
                                System.out.println(line);
                                // telephoneDirectory.put(str[0], str[1]);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println("STEP2");

                        System.out.println(msg[3]);
                        String find = iSc.nextLine();
                        String deletedKey = "";
                        String deletedValue = "";
                        System.out.println("STEP3");
                        for (Entry <String, String> pair: telephoneDirectory.entrySet()) {
                            if (telephoneDirectory.containsKey(find) || telephoneDirectory.containsValue(find));
                            deletedKey = pair.getKey();
                            deletedValue = pair.getValue();
                        }
                        telephoneDirectory.remove(deletedKey, deletedValue);
                        String fileName = "phonebook.txt";
                        System.out.println("STEP4");
                        try {
                            FileChannel.open(Path.of(fileName), StandardOpenOption.WRITE)
                                    .truncate(0).close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println("STEP5");
                        try (FileWriter fw = new FileWriter ("phonebook.txt", true)){
                            for (Entry <String, String> pair: telephoneDirectory.entrySet()) {
                                fw.append(pair.getKey());
                                fw.append("\t");
                                fw.append(pair.getValue());
                                fw.append("\n");
                                fw.flush();
                            }
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }
                        System.out.println("STEP6");

                        for (Entry <String, String> pair: telephoneDirectory.entrySet()) {
                            System.out.printf("%s = %s\n", pair.getKey(), pair.getValue());
                        }
                        System.out.println("Contact is deleted");    
                        break;
                case "e":
                    exit = true;
                    break; 
                }
                
            } 
            iSc.close();
        }
        
    }
    




