import java.util.ArrayList;

public class Owner{
    private String name;
    /*List of properties*/
    private ArrayList<Property> properties = new ArrayList<>();
    private ArrayList<Double> payments = new ArrayList<>();
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
    public void viewProperty(){
        /* Return properties arraylist in readable format*/
        /* Command Line: */
        for (Property property : properties) {
            System.out.println(property.toString());
        }
    }
    public void payTax(Property p, int year){
        /* Take payment, create propertyTax, store in property.(Implement in PropertyTax)*/
        ArrayList<PropertyTax> history = new ArrayList<PropertyTax>();
        history = p.getTaxHistory();
        for (PropertyTax propertyTax : history) {
            if (propertyTax.getYear() == year) {
                propertyTax.setPaid(true);
            }
        }
        /* Need to add to CSV file */
    }
    public void viewPaidTax(){
        /* Return list of propertyTax*/
        for (Property p : properties) {
            System.out.println("\nTaxes Paid for Property at " + p.getAddress());
            ArrayList<PropertyTax> history = new ArrayList<PropertyTax>();
            history = p.getTaxHistory();
            for (PropertyTax tax : history) {
                if (tax.getPaid() == true) {
                    System.out.println("\nYear: " + tax.getYear() + "\nTax Paid: " + tax.getTax());
                }
            }
        }
    }
    public void viewUnpaidTax(){
        /* Return list of propertyTax*/
        for (Property p : properties) {
            System.out.println("\nTaxes Unpaid for Property at " + p.getAddress());
            ArrayList<PropertyTax> history = new ArrayList<PropertyTax>();
            history = p.getTaxHistory();
            for (PropertyTax tax : history) {
                if (tax.getPaid() == false) {
                    System.out.println("\nYear: " + tax.getYear() + "\nTax Unpaid: " + tax.getTax());
                }
            }
        }
    }
    public void viewOverdueTax(){
        /* Show overdue tax on property*/
            /* Show overdue tax on property*/
        for (Property p : properties) {
            System.out.println("\nTaxes Overdue for Property at " + p.getAddress());
            ArrayList<PropertyTax> history = new ArrayList<PropertyTax>();
            history = p.getTaxHistory();
            for (int y = 0; y < history.size(); y++) {
                System.out.println(history.size());
                PropertyTax tax = history.get(y);
                if ((tax.getPaid() == false) && (tax.getYear() != 2020)) {
                    System.out.println("\nYear: " + tax.getYear() + "\nTax Overdue: " + tax.getTax());
                }
            }
        }
        }
    public void balancingStatement(int year){
        /* Shows amount of tax paid for specific year*/
        for (Property p : properties) {
            ArrayList<PropertyTax> history = new ArrayList<PropertyTax>();
            history = p.getTaxHistory();
            for (PropertyTax tax : history) {
                if (tax.getPaid() == true && tax.getYear() == year) {
                    System.out.println("\nTax Paid in this year: " + tax.getYear() + ", "
                            + tax.getTax());
                }
            }
        }
    }
}
