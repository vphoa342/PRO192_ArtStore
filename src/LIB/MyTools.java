package LIB;

public class MyTools {
    // this class to print menu and input option and return option
    public static int inputChoice(String[] options) {
        int choice = 0;

        System.out.println("-----------------------------------");
        for (int i = 0; i <= options.length - 1; i++) {
            System.out.println((i + 1) + "." + options[i]);
        }
        System.out.println("-----------------------------------");

        choice = Validation.inputNumber("Enter choice: ");

        return choice;
    }
}
