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

    }
    public void registerProperty(Property p){
        p.createTaxHistory();
        properties.add(p);
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
    }
    public String viewPaidTax(){
        /* Prints all PAID Taxes */
        String s = "";
        for (int i = 0; i< properties.size(); i++){
            Property p = properties.get(i);
            s = "\nTaxes Paid for Property at " + String.valueOf(p.getAddress());
            ArrayList<PropertyTax> history = p.getTaxHistory();
            for (int y = 0; y < history.size(); y++){
                PropertyTax tax = history.get(y);
                if (tax.getPaid()){
                    s = s + "\nYear: " + tax.getYear() + "\nTax Paid: " + tax.getTax();
                }
            }
        }
        return s;
    }
    public String viewDueTax(){
        /* Prints THIS YEARS DUE Taxes */
        String s = "";
        for (int i = 0; i< properties.size(); i++){
            Property p = properties.get(i);
            s = "\nTax Due this year for Property at " + p.getAddress();
            ArrayList<PropertyTax> history = p.getTaxHistory();
            for (int y = 0; y < history.size(); y++){
                PropertyTax tax = history.get(y);
                if (!tax.getPaid()&&(tax.getYear() == 2020)){
                    s = s + "\nTax Due: " + tax.getTax();
                }
            }
        }
        return s;
    }
    public String viewOverdueTax(){
        /* Prints all OVERDUE Taxes, i.e NOT this years */
        String s = "";
        for (int i = 0; i< properties.size(); i++){
            Property p = properties.get(i);
            s = "\nTaxes Overdue for Property at " + p.getAddress();
            ArrayList<PropertyTax> history = p.getTaxHistory();
            for (int y = 0; y < history.size(); y++){
                PropertyTax tax = history.get(y);
                if ((!tax.getPaid())&&(tax.getYear() != 2020)){
                    s = s + "\nYear: " + tax.getYear() + "\nTax Overdue: " + tax.getTax();
                }
            }
        }
        return s;
    }
    public void viewOverdueTax(int year){
        /* Prints all OVERDUE Taxes for a YEAR */
        for (int i = 0; i< properties.size(); i++){
            Property p = properties.get(i);
            System.out.println("\nTaxes Overdue for Property at " + p.getAddress());
            ArrayList<PropertyTax> history = p.getTaxHistory();
            for (int y = 0; y < history.size(); y++){
                PropertyTax tax = history.get(y);
                if ((!tax.getPaid())&&(tax.getYear() == year)){
                    System.out.println("Tax Overdue: " + tax.getTax());
                }
            }
        }
    }
    public void viewOverdueTax(String routKey, int year){
        /* Prints all OVERDUE Taxes for a YEAR in a ROUTING KEY*/
        for (int i = 0; i< properties.size(); i++){
            Property p = properties.get(i);
            System.out.println("\nTaxes Overdue for Property at " + p.getAddress());
            ArrayList<PropertyTax> history = p.getTaxHistory();
            for (int y = 0; y < history.size(); y++){
                PropertyTax tax = history.get(y);
                if ((!tax.getPaid())&&(tax.getEircode().substring(0,3).equals(routKey))&&(tax.getYear() == year)){
                    System.out.println("Tax Overdue: " + tax.getTax());
                }
            }
        }
    }
    public String balancingStatement(int year){
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
        String s = "";
        s = "\nPaid tax in this year: " + year + ", " + paid;
        s = s + "\nUnpaid tax in this year: " + year + ", " + unpaid;
        return s;
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
    public String getName() {
        return name;
    }
    public ArrayList<Property> getProperties() {
        return properties;
    }
}
