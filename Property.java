public class Property
{
    /* Property info */
    private String address;
    private String eircode;
    private double marketValue;
    private String locationCategory;
    private boolean ppr;
    private int year;
    /* Tax/Payment History */


    public Property(String address, String eircode, double marketValue, String locationCategory, boolean ppr, int year){
        this.address = address;
        this.eircode = eircode;
        this.marketValue = marketValue;
        this.locationCategory = locationCategory;
        this.ppr = ppr;
        this.year = year;
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
