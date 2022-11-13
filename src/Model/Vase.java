package Model;

import LIB.EnterKey;
import LIB.Validation;

public class Vase extends Item {
    private int height;
    private String material;

    // constructor

    public Vase() {
        super(0, "");
        this.height = 0;
        this.material = "";
    }

    public Vase(int height, String material, String creator, int value) {
        super(value, creator);
        this.height = height;
        this.material = material;
    }

    // method
    @Override
    public void input() {
        super.input();
        String pattern = "^[a-zA-Z]+$";

        height = Validation.inputNumber("Enter height: ");
        material = Validation.inputString("Enter material: ", pattern);

    }

    @Override
    public String toString() {
        return super.toString() + "{" + " height='" + getHeight() + "'" + ", material='" + getMaterial() + "'" + "}";
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getMaterial() {
        return this.material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public void update() {
        super.update();

        this.setHeight(EnterKey.isEnterInteger("Enter height: ", this.getHeight()));
        this.setMaterial(EnterKey.isEnterString("Enter material: ", this.getMaterial()));
    }

}