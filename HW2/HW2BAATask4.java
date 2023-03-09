// в калькулятор из предыдущего ДЗ добавить логирование
import java.io.IOException;
import java.util.logging.*;
import java.util.InputMismatchException;
import java.util.Scanner;
public class HW2BAATask4 {
    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getLogger(HW2BAATask4.class.getName());
        logger.setLevel(Level.INFO);
        FileHandler fh = new FileHandler("logCalc.txt", true);
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);
        logger.setUseParentHandlers(false);
        
        Scanner iScanner = new Scanner(System.in);
        String[] msg = {"Please, input a first number: ", "Please, input a symbol of operation +, -, / or *: ",
                         "Please, input a second number: ", "\nЛогирование работы с калькулятором: \n", 
                         "Wrong number format", "Wrong operation"};
        Double number1 = getDouble(iScanner, msg[0]);
        if (number1 == 0.00000000001) {
            logger.warning(msg[0] + "\n" + msg[4]);
            System.out.println(msg[4]);
        } else {
            iScanner.nextLine();
            System.out.println(number1);
            logger.info(msg[3] + msg[0] + "\n" + Double.toString(number1));
            System.out.println(msg[1]);
            String operation = iScanner.nextLine().trim();
            logger.info(msg[1] + "\n" + operation);
            
            Double number2 = getDouble(iScanner, msg[2]);
            if (number2 == 0.00000000001) {
                logger.warning(msg[2] + "\n" + msg[4]);
                System.out.println(msg[4]);
            } else {
                logger.info(msg[2] + "\n" + Double.toString(number2));
                Double result = 0D;
                String wrong = "";
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
                        result = (number1 / number2);
                        break;
                default:
                wrong = msg[5];
                System.out.println(wrong);
                logger.warning(wrong);
                        break;
                }
                StringBuilder sb = new StringBuilder();
                if(wrong == "") {
                    sb.append("Result is: " + number1 + " " + operation + " " + number2 + " = " + result);
                    System.out.println(sb);
                    logger.info(sb.toString());
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
        }catch (InputMismatchException e) {  
            return 0.00000000001;
        }
    }
}
