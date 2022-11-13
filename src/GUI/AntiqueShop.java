package GUI;

import LIB.MyTools;
import LIB.Validation;
import Model.Item;
import Model.ItemList;
import Model.Order;
import Model.Painting;
import Model.Statue;
import Model.Vase;

public class AntiqueShop {
    public static void main(String[] args) {
        int choice = 0;
        int index = -1;
        int price = -1;
        String type = "";
        String typePattern = "Vase|Painting|Statue";
        String[] options = { "Add a new item", "Display all items", "Find items by creator", "Update item by index",
                "Remove item by index", "Sort items by value", "Buy item by index", "Remove the item from the shopcart",
                "print order", "report shopcart's item by price", "report shopcart's items by type" };
        String[] subOptions = { "Belong to vase", "Belong to statue", "Belong to painting" };

        // inventory
        ItemList inventory = new ItemList();
        Order ord = new Order();

        do {
            choice = MyTools.inputChoice(options);
            switch (choice) {
            case 1:
                Item it = null;
                int subChoice = MyTools.inputChoice(subOptions);
                switch (subChoice) {
                case 1:
                    it = new Vase();
                    it.input();
                    break;
                case 2:
                    it = new Statue();
                    it.input();
                    break;
                case 3:
                    it = new Painting();
                    it.input();
                    break;

                }
                if (inventory.addItem(it)) {
                    System.out.println("Add to the inventory successfully");
                } else {
                    System.out.println("The inventory is full. ");
                }
                break;
            case 2:
                inventory.displayAllItems();
                break;
            case 3:
                String creator = Validation.inputString("Enter creator to find: ", "");
                Item[] result = inventory.getItemsByCreator(creator);
                // display result
                for (int i = 0; i < result.length; i++) {
                    if (result[i] != null) {
                        System.out.println(result[i]);
                    } else {
                        break;
                    }

                }
                break;
            case 4:
                inventory.displayAllItems();
                index = Validation.inputNumber("Enter index: ");

                if (inventory.updateItem(index)) {
                    System.out.println("Update item successfully");
                } else {
                    System.out.println("No update");
                }

                break;
            case 5:
                inventory.displayAllItems();
                index = Validation.inputNumber("Enter index: ");

                if (inventory.removeItem(index)) {
                    System.out.println("Remove item sucessfully");
                    System.out.println("After remove");
                    inventory.displayAllItems();
                } else {
                    System.out.println("No remove");
                }

                break;
            case 6:
                if (inventory.sortByValue()) {
                    System.out.println("After sort: ");
                    inventory.displayAllItems();
                }
                break;

            case 7:
                inventory.displayAllItems();
                index = Validation.inputNumber("Input index: ");

                Item chosenItem = inventory.getItem(index);
                if (ord.getCustName().equals(""))
                    ord.input();
                if (ord.addItem(chosenItem)) {
                    System.out.println("Item added. ");
                    ord.toString();
                } else {
                    System.out.println(" Add fail");
                }

                break;
            case 8:
                inventory.displayAllItems();
                index = Validation.inputNumber("Input index: ");

                if (ord.removeItem(index)) {
                    System.out.println("Remove successfully. ");
                    ord.toString();
                } else {
                    System.out.println("Remove fail");
                }
                break;
            case 9:
                System.out.println(ord.toString());
                break;
            case 10:

                price = Validation.inputNumber("Enter price to report: ");

                ord.displayBoughtItems(price);
                break;
            case 11:
                type = Validation.inputString("Enter type to report: ", typePattern);
                System.out.println("Result: " + ord.countItemByType(type));
                break;
            }

        } while (choice <= 11);
    }
}
