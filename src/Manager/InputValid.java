/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import java.util.Scanner;

/**
 *
 * @author hoang
 */
public class InputValid {

    public static String inputPhone(String notify) {
        String myPhone = new String();
            try {
                myPhone = inputString(notify);
                if (!myPhone.matches("\\d{10,11}") || myPhone.charAt(0) != "0".charAt(0)) {
                    throw new Exception("Phone number invalid.");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return inputPhone(notify);
            }
        return myPhone;
    }

    public  int inputInteger(String notify) {
        Scanner input = new Scanner(System.in);
        int myNumber = 0;
            try {
                System.out.print(notify);
                myNumber = Integer.parseInt(input.nextLine());
                if (myNumber < 0) {
                    throw new Exception("\u001B[31mYou must input a non-negative number\u001B[1m");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage() + "\u001B[31m! Please retype your number!\u001B[1m");
                return inputInteger(notify);
            }
        return myNumber;
    }
    public static double inputDouble(String notify) {
        Scanner input = new Scanner(System.in);
        double myNumber = 0;
            try {
                System.out.print(notify);
                myNumber = Double.parseDouble(input.nextLine());
                if (myNumber < 0) {
                    throw new Exception("\u001B[31mYou must input a non-negative number\u001B[1m");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage() + "\u001B[31m! Please retype your number!\u001B[1m");
               return inputDouble(notify);
            }
        return myNumber;
    }
    public static boolean Confirm(String notify) {
        String myString;
        do {
            myString = inputString(notify);
        } while (!myString.equalsIgnoreCase("y") && !myString.equalsIgnoreCase("n"));
        return myString.equalsIgnoreCase("y");
    }

    public static String inputString(String notify) {
        Scanner input = new Scanner(System.in);
        System.out.print(notify);
        return input.nextLine();
    }
    
}
