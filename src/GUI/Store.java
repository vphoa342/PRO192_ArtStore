package GUI;

import LIB.MyTools;
import Model.Item;
import Model.Painting;
import Model.Statue;
import Model.Vase;

public class Store {
    public static void main(String[] args) {
        int choice = 0;

        Item obj = null;
        String[] options = { "create a vase", "create a statue", "create a painting", "display the accepted item" };
        do {
            choice = MyTools.inputChoice(options);
            switch (choice) {
            case 1:
                obj = new Vase();
                obj.input();
                break;
            case 2:
                obj = new Statue();
                obj.input();
                break;
            case 3:
                obj = new Painting();
                obj.input();
                break;
            case 4:
                if (obj != null) {
                    System.out.println(obj.toString());
                }
                break;
            }
        } while (choice <= 4);
    }
}
