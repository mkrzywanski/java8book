package chapter4.task6;

import java.util.Objects;

public class DiscountedItem extends Item {
    private double discount;

    public DiscountedItem(String description, double price, double discount) {
        super(description, price);
        this.discount = discount;
    }

    public boolean equals(Object otherObject) {
        if(otherObject instanceof Item) {
            boolean i = super.equals(otherObject);
            if(otherObject instanceof DiscountedItem) {
                return i && this.discount == ((DiscountedItem) otherObject).discount;
            }
            return i;
        }
        return false;

    }
    
    public int hashCode() {
        return Objects.hash(super.hashCode(), discount);
    }
}