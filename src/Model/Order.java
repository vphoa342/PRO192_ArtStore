package Model;

import LIB.Validation;

public class Order {
    private String code;
    private int totalMoney;
    private Item[] shopCart;
    private int noItems;
    private String custName;
    private final int MAX = 100;

    public Order() {
        this.code = "";
        this.totalMoney = 0;
        this.shopCart = new Item[MAX];
        this.noItems = 0;
        this.custName = "";
    }

    public Order(String code, int totalMoney, Item[] shopCart, int noItems, String custName) {
        this.code = code;
        this.totalMoney = totalMoney;
        this.shopCart = shopCart;
        this.noItems = noItems;
        this.custName = custName;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getTotalMoney() {
        return this.totalMoney;
    }

    public void setTotalMoney() {
        for (int i = 0; i < this.noItems; i++) {
            this.totalMoney += this.shopCart[i].getValue();
        }
    }

    public Item[] getshopCart() {
        return this.shopCart;
    }

    public void setshopCart(Item[] shopCart) {
        this.shopCart = shopCart;
    }

    public int getNoItems() {
        return this.noItems;
    }

    public void setNoItems(int noItems) {
        this.noItems = noItems;
    }

    public String getCustName() {
        return this.custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    @Override
    public String toString() {
        String output = "";
        output += "Code: " + this.getCode() + "\n";
        output += "TotalMoney='" + this.getTotalMoney() + "\n";
        output += "Customer name: " + this.custName + "\n";
        output += "No of items: " + this.noItems + "\n";
        for (int i = 0; i < this.noItems; i++) {
            output += i + "." + this.shopCart[i] + "\n";
        }
        return output;
    }

    // method
    public void input() {
        String codePattern = "^[A-Za-z0-9]+";
        String custNamePattern = "^[a-zA-Z\\s]+";
        this.code = Validation.inputString("Enter code: ", codePattern);
        this.custName = Validation.inputString("Enter customer name: ", custNamePattern);

    }

    public boolean addItem(Item chosenItem) {
        this.shopCart[this.noItems] = chosenItem;
        this.noItems += 1;
        return true;
    }

    public boolean removeItem(int index) {
        for (int i = index; i < noItems; i++) {
            this.shopCart[i] = this.shopCart[i + 1];
        }
        this.noItems -= 1;
        return true;
    }

    // this method to print out all items that have value below given value
    public void displayBoughtItems(int value) {
        for (int i = 0; i < this.noItems; i++) {
            if (this.shopCart[i].getValue() <= value) {
                System.out.println(i + ". " + this.shopCart[i].toString());
            }
        }
    }

    public int countItemByType(String type) {
        int countResult = 0;
        for (int i = 0; i < this.noItems; i++) {
            if (this.shopCart[i].getClass().equals(type)) {
                countResult += 1;
            }
        }
        return countResult;
    }
}
