// В калькулятор добавьте возможность отменить последнюю операцию.

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.*;
import java.util.InputMismatchException;
import java.util.Scanner;
public class HW4_3 {
    public static void main(String[] args) throws IOException {
    Double number1=null;
    Double number2=null;
    String operation=null;
    
    while (true){
        Scanner iScanner = new Scanner(System.in);
        String[] msg = {"00 Please, input a first number: ", 
                        "01 Please, input a symbol of operation +, -, / or *:",
                        "02 Please, input a second number:", "\n03 Calculation logging: \n", 
                        "04 Wrong number format", "05 Wrong operation", "05 Division by zero",
                        "07 Xoba"};
        // if(iScanner.hasNext()) iScanner.next();
        number1 = getDouble(iScanner, msg[0]);
        //  { // возвращает истину если с потока ввода можно число
        System.out.println(number1);
            
        if (number1 == 0.00000000001) {
            // break;
            while (number1 == 0.00000000001) {
                number1 = getDouble(iScanner, msg[0]);
            }
        }  
        iScanner.nextLine();
            // System.out.println(number1);
            logCalc((msg[3] + msg[0] + "\n" + Double.toString(number1)), true);
            System.out.println(msg[1]);
            operation = iScanner.nextLine().trim();
            logCalc(msg[1] + "\n" + operation,true);
            
            number2 = getDouble(iScanner, msg[2]);
            if (number2 == 0.00000000001) {
                logCalc(msg[2] + "\n" + msg[4], false);
                System.out.println(msg[4]);
                // break;
            }
            else {
                logCalc(msg[2] + "\n" + Double.toString(number2), true);
                Double result = 0D;
                Boolean wrong = false;
                switch (operation) {
                    case "+":
                        result = number1 + number2;
                        break;
                    case "-":
                        result = number1 - number2;
                        break;
                    case "*":
                        result = number1 * number2;
                        break;
                    case "/":
                        if (number2 != 0D) result = (number1 / number2);
                        else logCalc(msg[6] + " /0", false);
                        break;
                    case "n":
                    case "N":
                        System.out.println("зачистить стек и начать сначала");
                            break;
                    case "z":
                    case "Z":
                        System.out.println("удалить из стека последнюю операцию и вернуть значение до нее");
                            break;
                default:
                wrong = true;
                System.out.println(msg[5]);
                logCalc(msg[5],false);
                        break;
                }
                StringBuilder sb = new StringBuilder();
                if(wrong != true) {
                    sb.append("Result is: " + number1 + " " + operation + " " + number2 + " = " + result);
                    System.out.println(sb);
                    logCalc(sb.toString(), true);
                }
            }
            iScanner.close();
        }
    }
    
    private static Double getDouble(Scanner iScanner, String message) throws InputMismatchException, SecurityException, IOException {
        try {
            System.out.println(message);
            if(iScanner.hasNext()) Double num = iScanner.nextDouble();
            
            return num;
        } catch (Exception e) {  
            logCalc("04 Wrong number format", false);
            System.out.println("04 Wrong number format");
            return 0.00000000001;
        }
    }

    private static void logCalc(String data, Boolean info) throws InputMismatchException, SecurityException, IOException {
        try{
            Logger logger = Logger.getLogger(HW4_3.class.getName());
            logger.setLevel(Level.INFO);
            
            
            FileHandler fh = new FileHandler("logCalc.txt", false);
            logger.addHandler(fh);
            SimpleFormatter sFormat = new SimpleFormatter();
            fh.setFormatter(sFormat);
            logger.setUseParentHandlers(false);
            
            
            if (info) logger.info(data);
            else logger.warning(data);
        } catch (Exception e) {
            System.out.println("You have a problem with File writing");
        }
    }
}
