package Model;

import LIB.EnterKey;
import LIB.Validation;

public class Painting extends Item {
    private int width;
    private int height;
    private boolean isWatercolor;
    private boolean isFramed;

    // constructor

    public Painting() {
        super(0, "");
        this.width = 0;
        this.height = 0;
        this.isFramed = false;
        this.isWatercolor = false;
    }

    public Painting(int width, int height, String creator, int value, boolean isWatercolor, boolean isFramed) {
        super(value, creator);
        this.width = width;
        this.height = height;
        this.isFramed = isFramed;
        this.isWatercolor = isWatercolor;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isIsWatercolor() {
        return this.isWatercolor;
    }

    public boolean getIsWatercolor() {
        return this.isWatercolor;
    }

    public void setIsWatercolor(boolean isWatercolor) {
        this.isWatercolor = isWatercolor;
    }

    public boolean isIsFramed() {
        return this.isFramed;
    }

    public boolean getIsFramed() {
        return this.isFramed;
    }

    public void setIsFramed(boolean isFramed) {
        this.isFramed = isFramed;
    }

    // method
    @Override
    public void input() {
        super.input();
        width = Validation.inputNumber("Enter width: ");
        height = Validation.inputNumber("Enter height: ");
    }

    @Override
    public String toString() {
        return super.toString() + "{" + " width='" + getWidth() + "'" + ", height='" + getHeight() + "'"
                + ", isWatercolor='" + isIsWatercolor() + "'" + ", isFramed='" + isIsFramed() + "'" + "}";
    }

    @Override
    public void update() {
        super.update();
        this.setWidth(EnterKey.isEnterInteger("Enter width: ", this.getWidth()));
        this.setHeight(EnterKey.isEnterInteger("Enter height: ", this.getHeight()));

        this.setIsWatercolor(EnterKey.isEnterBoolean("Enter is watercolor: ", this.isIsWatercolor()));
        this.setIsFramed(EnterKey.isEnterBoolean("Enter is framed: ", this.isIsFramed()));

    }

}
