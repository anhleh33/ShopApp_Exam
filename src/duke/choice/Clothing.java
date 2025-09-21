package duke.choice;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Clothing implements Comparable<Clothing> {
    private String description;
    private double price;
    private String size = "M";

    private final double MIN_PRICE = 10.0;
    private final double MIN_TAX = .2;

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return Math.round((price + price*MIN_PRICE)*100)/100.0;
    }

    public void setPrice(double price) {
        this.price = (price > MIN_PRICE) ? price : MIN_PRICE;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Clothing(String description, double price){
        this.description = description;
        this.price = price;
    }

    public void print(){
        System.out.println(description + " ($" + price + ")");
    }

    @JsonIgnore
    public boolean isSizeL(){
        return size.equals("L");
    }

    @Override
    public String toString(){
        return description + ", " + size + ", " +  "($" + price + ")";
    }

    @Override
    public int compareTo(Clothing other) {
        return this.description.compareTo(other.description);
    }
}
