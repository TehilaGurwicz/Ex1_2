//package assignments.ex1;
import java.util.Scanner;

/**
 * Intro2CS, Ex1 - very basic "main template"
 * Make sure your implementation of this main performs as the Ex1Sol.jar solution implement all needed functions.
 *
 */
public class Ex1Main
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = "12b3", num2 = "", quit = "quit";
        while (!num1.equals(quit) && !num2.equals(quit)) {
            System.out.println("Ex1 class solution:");
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.next();
            if (Ex1.isNumber(num1)) {
                if (!num1.equals("quit")) {
                    System.out.println("num1" + "=" + num1 + " is number:" + Ex1.isNumber(num1) + "," + "value:" + Ex1.number2Int(num1));
                } else break;
                System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
                num2 = sc.next();
                if (Ex1.isNumber(num2)) {
                    if (!num2.equals("quit")) {
                        System.out.println("num2" + "=" + num2 + " is number:" + Ex1.isNumber(num2) + "," + "value:" + Ex1.number2Int(num2));
                    } else break;
                    System.out.println("Enter a base for output: (a number [2,16])");
                    int base = sc.nextInt();
                    int sum = 0;
                    int result = 0;

                    if (base >= 2 || base <= 16) {
                        sum = sum + Ex1.number2Int(num1) + Ex1.number2Int(num2);
                        result = result + Ex1.number2Int(num1) * Ex1.number2Int(num2);
                        System.out.println(num1 + "+" + num2 + "=" + Ex1.int2Number(sum, base));
                        System.out.println(num1 + "*" + num2 + "=" + Ex1.int2Number(result, base));
                        String[] max = {num1, num2, Ex1.int2Number(sum, base), Ex1.int2Number(result, base)};

                        System.out.println("The max index in [" + num1 + ", " + num2 + ", " + sum + ", " + result + "] is:" + max[Ex1.maxIndex(max)]);
                    }
                }
                else if (num1=="quit" || !Ex1.isNumber(num2))
                {
                    System.out.println("num2" + "=" + num2 + " is number:" + Ex1.isNumber(num2) + "," + "value:" + Ex1.number2Int(num2));
                    System.out.println("ERR: number#2 is in the wrong format!" + "("+num2+")");}
            }
            else if (num1=="quit")
            {
                System.out.println("num1" + "=" + num1 + " is number:" + Ex1.isNumber(num1) + "," + "value:" + Ex1.number2Int(num1));
                System.out.println("ERR: number#1 is in the wrong format!" + "("+num1+")");}
            }
        System.out.println("quiting now...");

            }
    }

