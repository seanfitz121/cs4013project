import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
public class PropertyTax extends Property{
    private double tax;
    private boolean paid;
    private int year;
    private int regYear;
    public PropertyTax(String address, String eircode, double marketValue, String locationCategory, boolean ppr, int regYear, int year){
        super(address, eircode, marketValue, locationCategory, ppr, regYear);
        this.tax = getPropertyTax(year);
        this.paid = false;
        this.year = year;
        this.regYear = regYear;
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
    public int getYear(){
        return this.year;
    }
    public double getTax(){
        return this.tax;
    }
    public void setPaid(){
        this.paid = true;
        try {
            FileWriter csvWriter = new FileWriter("record.csv", true);
            csvWriter.append(String.join("", super.getEircode(),","));
            csvWriter.append(String.join("", Double.toString(tax),","));
            csvWriter.append(String.join("", Integer.toString(regYear),","));
            csvWriter.append(String.join("", Integer.toString(year),","));
            csvWriter.append("\n");
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public boolean getPaid(){
        return this.paid;
    }
}
