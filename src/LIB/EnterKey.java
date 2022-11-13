package LIB;

import java.util.Scanner;

public class EnterKey {
    public static int isEnterInteger(String message, int x) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = false;
        do {
            try {
                System.out.print(message);
                String readString = scanner.nextLine();
                if (readString.isEmpty()) {
                    return x;
                } else {
                    x = Integer.parseInt(readString);

                }
                flag = false;
            } catch (Exception e) {
                // TODO: handle exception
                flag = true;
                System.out.println("Invalid.");
            }
        } while (flag);
        return x;
    }

    public static String isEnterString(String message, String x) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = false;

        do {

            try {
                System.out.print(message);
                String readString = scanner.nextLine();
                if (readString.isEmpty()) {
                    return x;

                } else {
                    x = String.valueOf(readString);

                }
                flag = false;
            } catch (Exception e) {
                // TODO: handle exception
                flag = true;
                System.out.println("Invalid.");
            }
        } while (flag);
        return x;
    }

    public static boolean isEnterBoolean(String message, boolean x) {
        Scanner scanner = new Scanner(System.in);

        boolean flag = false;

        do {

            try {
                System.out.print(message);
                String readString = scanner.nextLine();
                if (readString.isEmpty()) {
                    return x;

                } else {
                    x = Boolean.parseBoolean(readString);

                }
                flag = false;
            } catch (Exception e) {
                // TODO: handle exception
                flag = true;
                System.out.println("Invalid.");
            }
        } while (flag);
        return x;
    }
}
