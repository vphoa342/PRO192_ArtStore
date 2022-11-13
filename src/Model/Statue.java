package Model;

import LIB.EnterKey;
import LIB.Validation;

public class Statue extends Item {
    private int weight;
    private String color;

    // constructor

    public Statue() {
        super(0, "");
        this.weight = 0;
        this.color = "";
    }

    public Statue(int weight, String color, String creator, int value) {
        super(value, creator);
        this.weight = weight;
        this.color = color;
    }

    // method
    public void input() {
        super.input();
        String pattern = "^[a-zA-Z]+$";
        weight = Validation.inputNumber("Enter weight: ");
        color = Validation.inputString("Enter color: ", pattern);
    }

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return super.toString() + "{" + " weight='" + getWeight() + "'" + ", color='" + getColor() + "'" + "}";
    }

    @Override
    public void update() {
        super.update();
        this.setWeight(EnterKey.isEnterInteger("Enter weight: ", this.getWeight()));
        this.setColor(EnterKey.isEnterString("Enter color: ", this.getColor()));
    }

}
