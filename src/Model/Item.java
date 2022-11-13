package Model;

import LIB.EnterKey;
import LIB.Validation;

public class Item {
    // fields
    private int Value;
    private String Creator;

    // constructor
    public Item() {
        Value = 0;
        Creator = null;
    }

    public Item(int Value, String Creator) {
        this.Value = Value;
        this.Creator = Creator;
    }

    public Item(Item sv) {
        this.Value = sv.Value;
        this.Creator = sv.Creator;
    }

    // setter
    public void setValue(int Value) {
        this.Value = Value;
    }

    public void setCreator(String Creator) {
        this.Creator = Creator;
    }

    // getter
    public int getValue() {
        return this.Value;
    }

    public String getCreator() {
        return this.Creator;
    }

    public void input() {
        String pattern = "^[a-zA-Z]+$";
        this.Value = Validation.inputNumber("Enter value: ");
        this.Creator = Validation.inputString("Enter creator: ", pattern);

    }

    @Override
    public String toString() {
        return "{" + " Value='" + getValue() + "'" + ", Creator='" + getCreator() + "'" + "}";
    }

    public void update() {
        this.setValue(EnterKey.isEnterInteger("Enter value: ", this.getValue()));
        this.setCreator(EnterKey.isEnterString("Enter creator: ", this.getCreator()));
    }

}
