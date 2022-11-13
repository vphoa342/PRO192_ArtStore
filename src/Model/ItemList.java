package Model;

// this class is used to store the list of items (vase, painting, statue)
public class ItemList {

    // field
    private Item[] list; // default is null
    private final int MAX = 100; // final is constant, dont code setter
    private int noOfItems;

    // constructor
    public ItemList() {
        this.list = new Item[MAX];
        this.noOfItems = 0;
    }

    public ItemList(Item[] list, int noOfItems) {
        this.list = list;
        this.noOfItems = noOfItems;
    }

    // getter setter
    public Item[] getList() {
        return this.list;
    }

    public void setList(Item[] list) {
        this.list = list;
    }

    public int getMAX() {
        return this.MAX;
    }

    public int getNoOfItems() {
        return this.noOfItems;
    }

    public void setNoOfItems(int noOfItems) {
        this.noOfItems = noOfItems;
    }

    public ItemList list(Item[] list) {
        setList(list);
        return this;
    }

    public ItemList noOfItems(int noOfItems) {
        setNoOfItems(noOfItems);
        return this;
    }

    // override
    @Override
    public String toString() {
        return "{" + " list='" + getList() + "'" + ", MAX='" + getMAX() + "'" + ", noOfItems='" + getNoOfItems() + "'"
                + "}";
    }

    // method
    public boolean addItem(Item it) {
        if (this.noOfItems >= MAX)
            return false;
        this.list[noOfItems] = it;
        this.noOfItems++;
        return true;
    }

    public void displayAllItems() {
        for (int i = 0; i <= this.noOfItems - 1; i++) {
            System.out.println(this.list[i].toString());
        }
    }

    // this function return new list that contain items by a given creator
    public Item[] getItemsByCreator(String creator) {

        Item[] resultItem = new Item[MAX];
        int lenResult = 0;
        for (int i = 0; i < this.noOfItems; i++) {
            if (this.list[i].getCreator().equals(creator)) {
                resultItem[lenResult] = this.list[i];
                lenResult += 1;
            }
        }

        return resultItem;
    }

    public boolean updateItem(int index) {
        if (index < 0 || index >= noOfItems)
            return false;
        list[index].update();
        return true;
    }

    public boolean removeItem(int index) {
        if (index < 0 || index >= this.noOfItems) {
            return false;
        }

        for (int i = index; i < this.noOfItems; i++) {
            this.list[i] = this.list[i + 1];
        }
        this.noOfItems -= 1;
        return true;
    }

    public boolean sortByValue() {
        for (int i = 0; i < noOfItems; i++) {
            for (int j = noOfItems - 1; j > i; j--) {
                if (list[j].getValue() < list[j - 1].getValue()) {
                    Item tmp = list[j];
                    list[j] = list[j - 1];
                    list[j - 1] = tmp;

                }
            }
        }
        return true;
    }

    public Item getItem(int index) {
        if (index < 0 || index > this.noOfItems) {
            return null;
        }
        return this.list[index];
    }

}
