package calculator;

import java.util.Scanner;
import java.lang.Math;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Calculator {
    public double sqr_root(double no)
    {   //square root
        double result = 0;
        try{
            logger.info("Calculating Square root  of number " + no);
            if(no < 0){
                result = Double.NaN;
                throw new ArithmeticException("Case of NaN squareRoot of < 0");
            }
            else{
                result = Math.sqrt(no);
            }
        }catch(ArithmeticException err){
            logger.error("Number cannot be negative " + err.getMessage());
        }finally {
            logger.info("Result of squareRoot is : " + result);
        }

        return result;
    }

    public double factorial(double no)
    {
        double result = 1;
        try{
            if(no < 0) {
                result = Double.NaN;
                throw new ArithmeticException("Case of NaN factorial if < 0");
            }
            if(no!=(int)no)
            {
                result = Double.NaN;
                throw new ArithmeticException("Case of NaN factorial if num is not an integer");
            }

            if(no == 0 || no == 1) return 1;

            for(int i = 1; i <= no; i++){
                result *= i;
            }
        }
        catch(ArithmeticException err) {
            logger.error("Number cannot be negative " + err.getMessage());
        }
        finally {
            logger.info("Result of factorial is: " + result);
        }

        return result;
    }

    public double nat_logarithm(double no) {
        double result = 0;
        try{
            logger.info("Calculating Natural log of " + no);
            if(no <= 0){
                result = Double.NaN;
                throw new ArithmeticException("Case of NaN log of <= 0");
            }
            else{
                result = Math.log(no);
            }
        }
        catch(ArithmeticException err){
            logger.error("Number cannot be negative " + err.getMessage());
        }
        finally {
            logger.info("Result of naturalLog is : " + result);
        }
        return result;
    }

    public double power(double no1, double no2)
    {
        double result = 0;
        if(no1==0.0&&no2==0.0)
        {
            result = Double.NaN;
            logger.info("0 power 0 is not defined");
            return result;
        }
        try {
            logger.info("Calculating Power of two numbers " + no1 + " and " + no2);
            result = Math.pow(no1, no2);
            if(result==Double.NaN) {
                throw new ArithmeticException("Power is not real");
            }
        }catch (ArithmeticException ae)
        {
            logger.error(ae.getMessage());
        }
        logger.info("Result of power is : " + result);
        return result;
    }

    private static final Logger logger = LogManager.getLogger(Calculator.class);

    public static void main(String[] args) {
        double no1, no2;
        Calculator mini_calc = new Calculator();
        Scanner scanner = new Scanner(System.in);
        char option='y';
        do {
            System.out.println("\n\n\t\t\tScientific Calculator \n 1. Square Root \n 2. Factorial \n 3. Natural Log \n 4. Power \n 5. Exit\n");
            System.out.println("Enter your choice(1-5)");
            char oper = scanner.next().charAt(0);
            //scanner.close();
            double result=0.0;

            switch (oper) {
                case '1':
                    System.out.print("Enter number:");
                    no1 = scanner.nextDouble();
                    try {
                        result = mini_calc.sqr_root(no1)   ;
                    }catch (Exception e)
                    {
                        System.out.println(e);
                    }
                    break;

                case '2':
                    System.out.print("Enter number:");
                    no1 = scanner.nextDouble();
                    result = 1;
                    try {
                        result = mini_calc.factorial(no1);
                    }catch (Exception e)
                    {
                        System.out.println(e);
                    }

                    //result = no1;
                    break;

                case '3':
                    System.out.print("Enter number:");
                    no1 = scanner.nextDouble();
                    try {
                        result = mini_calc.nat_logarithm(no1);
                    }catch (Exception e)
                    {
                        System.out.println(e);
                    }
                    break;

                case '4':
                    System.out.print("Enter first number:");
                    no1 = scanner.nextDouble();
                    System.out.print("Enter second number:");
                    no2 = scanner.nextDouble();
                    try {
                        result = Math.pow(no1, no2);
                    }catch(Exception e)
                    {
                        System.out.println(e);
                    }

                    break;
                case '5':
                    System.out.print("\n\t\t\tTerminating Calculator\n");
                    return;
                default:
                    System.out.printf("Please enter correct choice\n");
                    return;
            }

            System.out.println("result: " + result);
            System.out.println("Press y to continue");
            option = scanner.next().charAt(0);
        }while(option=='y');
        scanner.close();
    }
}
