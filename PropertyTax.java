import java.util.Calendar;
public class PropertyTax extends Property{
    private double tax;
    private boolean paid;
    private int year;
    public PropertyTax(String address, String eircode, double marketValue, String locationCategory, boolean ppr, int regYear, int year){
        super(address, eircode, marketValue, locationCategory, ppr, regYear);
        this.tax = getPropertyTax(year);
        this.year = year;
    }
    public double getPropertyTax(int year){
        double tax = 100;
        if (super.getMarketValue() > 650000) {
            tax = tax + (super.getMarketValue()*.04);
        } else if (super.getMarketValue() > 400001) {
            tax = tax + (super.getMarketValue()*.02);
        } else if (super.getMarketValue()> 150000) {
            tax = tax + (super.getMarketValue()*.01);
        }
        if (super.getLocationCategory().equals("City")) {
            tax = tax + 100;
        } else if (super.getLocationCategory().equals("Large town")) {
            tax = tax + 80;
        } else if (super.getLocationCategory().equals("Small town")) {
            tax = tax + 60;
        } else if (super.getLocationCategory().equals("Village")){
            tax = tax + 50;
        } else if (super.getLocationCategory().equals("Countryside")) {
            tax = tax + 25;
        }
        if (!super.getPpr()){
            tax = tax + 100;
        }
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        for(int i = 0; i < currentYear-year; i++){
            tax = tax*1.07;
        }
        return tax;
    }
    public double getTax(){
        return this.tax;
    }
    public void setPaid(boolean paid){
        this.paid = paid;
    }
    public boolean getPaid(){
        return this.paid;
    }
    public int getYear(){
        return this.year;
    }
}