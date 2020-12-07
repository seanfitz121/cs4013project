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
        properties.add(p);
        System.out.println(p + " Registered");
    }
    public void viewProperty(){
        /* Return properties arraylist in readable format*/
    }
    public void payTax(){
       /* Take payment, create propertyTax, store in property.(Implement in PropertyTax)*/
    }
    public void viewTax(){
        /* Return list of propertyTax*/
    }
    public void viewOverdueTax(){
        /* Show overdue tax on property*/
    }
    public void yearQuery(){
        /* Search property data by year and return tax/overdue tax/payments made */
    }
    public void balancingStatement(){
        /* Shows amount of tax paid for specific year*/
    }
}
