package LIB;

import java.util.Scanner;

public class Validation {
    public static int inputNumber(String message) {
        int number = -1;
        boolean flag = false;

        do {
            System.out.print(message);
            Scanner sc = new Scanner(System.in);
            try {
                number = sc.nextInt();
                flag = false;
            } catch (Exception e) {
                // TODO: handle exception
                flag = true;
                System.out.println("Invalid.");
            }
        } while (flag);
        return number;
    }

    public static String inputString(String message, String pattern) {
        String result = null;
        boolean flag = false;

        do {
            System.out.print(message);
            Scanner sc = new Scanner(System.in);
            try {
                result = sc.nextLine();
                if (pattern != "" && !result.matches(pattern))
                    throw new Exception();
                flag = false;
            } catch (Exception e) {
                // TODO: handle exception
                flag = true;
                System.out.println("Invalid.");
            }
        } while (flag);
        return result;

    }

    public static boolean inputBoolean(String message) {
        boolean flag = false;
        boolean results;

        do {
            System.out.print(message);
            Scanner sc = new Scanner(System.in);
            try {
                results = sc.nextBoolean();
                flag = false;
                return results;
            } catch (Exception e) {
                // TODO: handle exception
                flag = true;
                System.out.println("Invalid.");
            }
        } while (flag);

        return false;
    }
}
