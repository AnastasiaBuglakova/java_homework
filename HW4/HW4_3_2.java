
    // 3 В калькулятор добавьте возможность отменить последнюю операцию.
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.*;
import java.util.Deque;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;
public class HW4_3_2{
    public static void main(String[] args) throws IOException {
        Double number1=null;
        Double number2=null;
        String operation=null;
        Double result=null;
        
        Scanner iScanner = new Scanner(System.in);
        String[] msg = {"00 Please, input a first number: ", 
                        "01 Please, input a symbol of operation +, -, / or *:",
                        "02 Please, input a second number:", "\n03 Calculation logging: \n", 
                        "04 Wrong number format", "05 Wrong operation", "05 Division by zero",
                        "07 Hello, \nfor continuation enter -> \"c\",\nfor cancel last operation enter -> \"z\",\nfor new calculation enter -> \"n\""};
        Deque <String> dq = new LinkedList<>();
                        while (true){
            Boolean newOperation = true;
            Boolean cancel = false;

            if (result!=null ){
                System.out.println(msg[7]);
                String action = iScanner.nextLine().trim().toLowerCase();
                
                switch (action) {
                    case "c":
                        number1=Double.parseDouble(dq.getLast());
                        
                        dq.addLast(Double.toString(number1));
                        newOperation = false;
                        logCalc("Operation = continue", true);
                        break;
                    case "n":
                
                        logCalc("Operation = new op", true);
                        break;
                    case "z":
                        result = cancelLastOp(result, operation, number2);
                        cancel = true;
                        if (dq.peek()!=null){
                            dq.removeLast(); dq.removeLast();dq.removeLast();dq.removeLast();
                        } else {System.out.println("Canselation is not possible");
                        }
                        
                        System.out.println(dq);
                        newOperation = false;
                        logCalc("Operation = cancel of last op", true);
                        break;
                }
            }
                if (!cancel){
                if (newOperation){    
                    System.out.println(msg[0]);
                    number1=getDouble(iScanner);
                    dq.addLast(Double.toString(number1));
                    
                    iScanner.nextLine();
                }
                logCalc((msg[3] + msg[0] + "\n" + Double.toString(number1)), true);
                System.out.println(msg[1]);
                operation = iScanner.nextLine().trim();
                
                while (!(operation.contains("+") || operation.contains("-")|| operation.contains("*")|| operation.contains("/"))){
                    
                    System.out.println(msg[1]);
                    operation = iScanner.nextLine().trim();
                }
                logCalc(msg[1] + "\n" + operation,true);
                dq.addLast(operation);

                System.out.println(msg[2]);
                number2 = getDouble(iScanner);

                dq.addLast(Double.toString(number2));
                // System.out.println(msg[4]);
                
                logCalc(msg[2] + "\n" + Double.toString(number2), true);
                result = getResult(number1, operation, number2, result);
                dq.addLast(Double.toString(result));
                System.out.println(dq);
                    }
            
            System.out.printf("Result is: %.2f\n",result);
            System.out.printf("Please click enter to chose next operation");
            
            
            iScanner.nextLine();
                logCalc(("Result is: %d" + result), true);
                
            // iScanner.close();    
        }    }
            
    public static Double cancelLastOp(Double res, String op, Double num2){
        switch (op) {
            case "+":
                res -= num2;
                break;
            case "-":
                res += num2;
                break;
            case "*":
                res = res / num2;
                break;
            case "/":
                res = res * num2;
            }
            return res;
        }

    public static Double getDouble(Scanner iScanner) throws InputMismatchException, SecurityException, IOException {
            Double num =null;
            while(num==null || num.isNaN()){
                
                try {
                    // iScanner.nextLine();
                    num = iScanner.nextDouble();
                } catch (Exception e) {  
                    // logCalc("04 Wrong number format", false);
                    System.out.println("04 Wrong number format, please, enter a number");
                    iScanner.nextLine();
                }
            
                }
                return num;
            }
            
    public static Double getResult(Double num1, String op,Double num2, Double res) {
                switch (op) {
                    case "+":
                        res = num1 + num2;
                        break;
                    case "-":
                        res = num1 - num2;
                        break;
                    case "*":
                        res = num1 * num2;
                        break;
                    case "/":
                        res = num1 / num2;
                        break;
                }
                return res;
            }      

    private static void logCalc(String data, Boolean info) throws InputMismatchException, SecurityException, IOException {
                try{
                    Logger logger = Logger.getLogger(HW4_3_2.class.getName());
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

        
        

