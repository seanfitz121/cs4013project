import java.io.*;
import java.util.ArrayList;

public class Owner {
    private String name;
    /*List of properties*/
    private ArrayList<Property> properties = new ArrayList<>();
    public Owner(String name){
        this.name = name;
    }
    public void registerProperty(String address, String eircode, double marketValue, String locationCategory, boolean ppr, int year){
        Property p = new Property(address, eircode, marketValue, locationCategory, ppr, year);
        p.createTaxHistory();
        properties.add(p);
        System.out.println(p.getAddress() + " Registered");
    }
    public void registerProperty(Property p){
        p.createTaxHistory();
        properties.add(p);
        System.out.println(p.getAddress() + " Registered");
    }
    public void viewProperties(){
        /* Prints properties array */
        for (int i = 0; i< properties.size(); i++){
            System.out.println(properties.get(i).toString());
        }
    }
    public void payTax(Property p, int year){
        /* Take payment, create propertyTax, store in property.(Implement in PropertyTax)*/
        ArrayList<PropertyTax> history = p.getTaxHistory();
        for (int i = 0; i < history.size(); i++){
            if(history.get(i).getYear() == year){
                history.get(i).setPaid();
            }
        }



        /* Need to add to CSV file*/
    }
    public void viewPaidTax(){
        /* Prints all PAID Taxes */
        for (int i = 0; i< properties.size(); i++){
            Property p = properties.get(i);
            System.out.println("\nTaxes Paid for Property at " + p.getAddress());
            ArrayList<PropertyTax> history = p.getTaxHistory();
            for (int y = 0; y < history.size(); y++){
                PropertyTax tax = history.get(y);
                if (tax.getPaid()){
                    System.out.println("\nYear: " + tax.getYear() + "\nTax Paid: " + tax.getTax());
                }
            }
        }
    }
    public void viewDueTax(){
        /* Prints THIS YEARS DUE Taxes */
        for (int i = 0; i< properties.size(); i++){
            Property p = properties.get(i);
            System.out.println("\nTax Due this year for Property at " + p.getAddress());
            ArrayList<PropertyTax> history = p.getTaxHistory();
            for (int y = 0; y < history.size(); y++){
                PropertyTax tax = history.get(y);
                if (!tax.getPaid()&&(tax.getYear() == 2020)){
                    System.out.println("\nTax Due: " + tax.getTax());
                }
            }
        }
    }
    public void viewOverdueTax(){
        /* Prints all OVERDUE Taxes, i.e NOT this years */
        for (int i = 0; i< properties.size(); i++){
            Property p = properties.get(i);
            System.out.println("\nTaxes Overdue for Property at " + p.getAddress());
            ArrayList<PropertyTax> history = p.getTaxHistory();
            for (int y = 0; y < history.size(); y++){
                PropertyTax tax = history.get(y);
                if ((!tax.getPaid())&&(tax.getYear() != 2020)){
                    System.out.println("\nYear: " + tax.getYear() + "\nTax Overdue: " + tax.getTax());
                }
            }
        }
    }
    public void balancingStatement(int year){
        /* Shows amount of tax, paid and unpaid, for specific year*/
        double unpaid = 0;
        double paid = 0;
        for (int i = 0; i< properties.size(); i++){
            Property p = properties.get(i);
            ArrayList<PropertyTax> history = p.getTaxHistory();
            for (int j = 0; j < history.size(); j++){
                PropertyTax tax = history.get(j);
                if (tax.getYear() == year){
                    if (tax.getPaid()){
                        paid = paid + tax.getTax();
                    } else {
                        unpaid = unpaid + tax.getTax();
                    }
                }
            }
        }
        System.out.println("\nPaid tax in this year: " + year + ", " + paid);
        System.out.println("\nUnpaid tax in this year: " + year + ", " + unpaid);
    }
    public void balancingStatement(Property p){
        /* Shows amount of tax paid for specific Property*/
        ArrayList<PropertyTax> history = p.getTaxHistory();
        System.out.println("\nAll taxes for Property at " + p.getAddress());
        for (int y = 0; y < history.size(); y++){
            PropertyTax tax = history.get(y);
            if (tax.getPaid()){
                System.out.println("\nYear: " + tax.getYear() + "\nTax Paid: " + tax.getTax());
            } else {
               System.out.println("\nYear: " + tax.getYear() + "\nTax Due: " + tax.getTax());
            }
        }    
    }
}
