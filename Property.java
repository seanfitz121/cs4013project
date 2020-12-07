public class Property
{
    private String owners;
    private String address;
    private String eircode;
    private double marketValue;
    private String locationCategory;
    private boolean ppr;
    private int year;
    public Property(String owners, String address, String eircode, double marketValue, String locationCategory, boolean ppr, int year){
        this.owners = owners;
        this.address = address;
        this.eircode = eircode;
        this.marketValue = marketValue;
        this.locationCategory = locationCategory;
        this.ppr = ppr;
        this.year = year;
    }
    public double getPropertyTax(){
        double tax = 100;
        if (this.marketValue > 650000) {
            tax = tax + (this.marketValue*.04); 
        } else if (this.marketValue > 400001) {
            tax = tax + (this.marketValue*.02); 
        } else if (this.marketValue > 150000) {
            tax = tax + (this.marketValue*.01); 
        }
        if (this.locationCategory.equals("City")) {
            tax = tax + 100; 
        } else if (this.locationCategory.equals("Large town")) {
            tax = tax + 80; 
        } else if (this.locationCategory.equals("Small town")) {
            tax = tax + 60; 
        } else if (this.locationCategory.equals("Village")){
            tax = tax + 50; 
        } else if (this.locationCategory.equals("Countryside")) {
            tax = tax + 25; 
        }
        if (this.ppr = false){
            tax = tax + 100;
        }
        return tax;
        // Need to add property tax unpaid thing
    }
    public String getOwners(){
        return this.owners;
    }
    public void setOwners(String owners){
         this.owners = owners;
    }
    public String getAddress(){
        return this.address;
    }
    public void setAddress(String address){
         this.address = address;
    }
    public String getEircode(){
        return this.eircode;
    }
    public void setEircode(String eircode){
         this.eircode = eircode;
    }
    public double getMarketValue(){
        return this.marketValue;
    }
    public void setMarketValue(double marketValue){
         this.marketValue = marketValue;
    }
    public String getLocationCategory(){
        return this.locationCategory;
    }
    public void setLocationCategory(String locationCategory){
         this.locationCategory = locationCategory;
    }
    public boolean getPpr(){
        return this.ppr;
    }
    public void setPpr(boolean ppr){
         this.ppr = ppr;
    }
    public int getYear(){
        return this.year;
    }
    public void setYear(int year){
         this.year = year;
    }
}
