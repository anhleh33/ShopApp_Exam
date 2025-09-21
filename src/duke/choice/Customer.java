package duke.choice;

import java.util.ArrayList;

public class Customer {
    private String name;
    private String size;

    private ArrayList<Clothing> items;

    public void addItems(ArrayList<Clothing> someItems) {
        this.items = someItems;
    }

    public ArrayList<Clothing> getItems() {
        return items;
    }

    public double getTotalPrice() {
        double total = 0;
        for(Clothing item : items) {
            if(size.equals(item.getSize())) {
                total += item.getPrice();
            }
        }
        return Math.round(total * 100) / 100.0;
    }

    public Customer(String name){
        this.name = name;
    }

    public void print(){
        System.out.println("Name: " + name);
        System.out.println("Size: " + size);
        System.out.println("Total Price: " + getTotalPrice());
        System.out.println();
    }

    public void setSize(int measurement){
        switch(measurement){
            case 1, 2, 3:
                size = "S";
                break;
            case 4, 5, 6:
                size = "M";
                break;
            case 7, 8, 9:
                size = "L";
                break;
            default:
                size = "X";
                break;
        }
    }
    public int getQuantitywithSizeL(){
        int cnt = 0;
        for(Clothing item : items) {
            if(item.isSizeL()) {
                cnt++;
            }
        }
        return cnt;
    }

    public double avaragePrice(){
        double sum = 0;
        try{
            sum = items.size()/getQuantitywithSizeL();
        }
        catch(ArithmeticException e){
            System.out.println("Don't divide by zero");
        }
        return sum;
    }
}
