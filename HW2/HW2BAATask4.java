// в калькулятор из предыдущего ДЗ добавить логирование
import java.io.IOException;
import java.util.logging.*;
import java.util.InputMismatchException;
import java.util.Scanner;
public class HW2BAATask4 {
    public static void main(String[] args) throws IOException {
        
        
        Scanner iScanner = new Scanner(System.in);
        String[] msg = {"Please, input a first number: ", "Please, input a symbol of operation +, -, / or *: ",
                         "Please, input a second number: ", "\nЛогирование работы с калькулятором: \n", 
                         "Wrong number format", "Wrong operation", "Division by zero"};
        Double number1 = getDouble(iScanner, msg[0]);
        if (number1 == 0.00000000001) {
            logCalc(msg[0] + "\n" + msg[4], false);
            System.out.println(msg[4]);
        } else {
            iScanner.nextLine();
            System.out.println(number1);
            logCalc((msg[3] + msg[0] + "\n" + Double.toString(number1)), true);
            System.out.println(msg[1]);
            String operation = iScanner.nextLine().trim();
            logCalc(msg[1] + "\n" + operation,true);
            
            Double number2 = getDouble(iScanner, msg[2]);
            if (number2 == 0.00000000001) {
                logCalc(msg[2] + "\n" + msg[4], false);
                System.out.println(msg[4]);
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
        }
        iScanner.close();
    }    
    private static Double getDouble(Scanner scanner, String message) throws InputMismatchException {
        try { 
            System.out.println(message);
            Double num = scanner.nextDouble();
            return num;
        } catch (InputMismatchException e) {  
            return 0.00000000001;
        }
    }

    private static void logCalc(String data, Boolean info) throws InputMismatchException, SecurityException, IOException {
        try{
            Logger logger = Logger.getLogger(HW2BAATask4.class.getName());
            logger.setLevel(Level.INFO);
            FileHandler fh = new FileHandler("HW2/logCalc.txt", true);
            logger.addHandler(fh);
            SimpleFormatter sFormat = new SimpleFormatter();
            fh.setFormatter(sFormat);
            logger.setUseParentHandlers(false);
            if (info) logger.info(data);
            else logger.warning(data);
        } catch (Exception e) {
            System.out.println("You have a problem with File writing.");
        }
    }
}
