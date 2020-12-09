import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
public class PropertyTax extends Property{
    private double tax;
    private boolean paid;
    private int year;
    private int regYear;
    private double upperBand = 650000;
    private double middleBand = 400001;
    private double lowerBand = 150000;
    public PropertyTax(String address, String eircode, double marketValue, String locationCategory, boolean ppr, int regYear, int year){
        super(address, eircode, marketValue, locationCategory, ppr, regYear);
        this.tax = getPropertyTax(year);
        this.paid = false;
        this.year = year;
        this.regYear = regYear;
    }
    public double getPropertyTax(int year){
        double tax = 100;
        double value = super.getMarketValue();
        if (value > upperBand) {
            tax = tax + (value*.04);
        } else if (value > middleBand) {
            tax = tax + (value*.02);
        } else if (value > lowerBand) {
            tax = tax + (value*.01);
        }
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        for(int i = 0; i < currentYear-year; i++){
            tax = tax*1.07;
        }
        tax = tax + getLocationTax();
        tax = tax + isPrivateResidence();
        return tax;
    }
    public double getLocationTax(){
        switch (super.getLocationCategory()) {
            case "City":
                tax = tax + 100;
                break;
            case "Large town":
                tax = tax + 80;
                break;
            case "Small town":
                tax = tax + 60;
                break;
            case "Village":
                tax = tax + 50;
                break;
            case "Countryside":
                tax = tax + 25;
                break;
        }
        return tax;
    }
    public double isPrivateResidence(){
        if (!super.getPpr()){
            tax = tax + 100;
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
