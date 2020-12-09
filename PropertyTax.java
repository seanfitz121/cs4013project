import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
public class PropertyTax extends Property{
    private double tax;
    private boolean paid;
    private int year;
    private int regYear;

    private double upperBand = 650000;
    private double upperBandPerc = .04;
    private double middleBand = 400001;
    private double middleBandPerc = .02;
    private double lowerBand = 150000;
    private double lowerBandPerc = .01;

    private double penalty = 1.07;

    private double City = 100;
    private double LargeT = 80;
    private double SmallT = 60;
    private double Village = 50;
    private double Countryside = 25;

    private double pprVal = 100;

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
            tax = tax + (value*upperBandPerc);
        } else if (value > middleBand) {
            tax = tax + (value*middleBandPerc);
        } else if (value > lowerBand) {
            tax = tax + (value*lowerBandPerc);
        }
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        for(int i = year; i < currentYear; i++){
            tax = tax*penalty;
        }
        tax = tax + getLocationTax();
        tax = tax + isPrivateResidence();
        return tax;
    }
    public double getLocationTax(){
        switch (super.getLocationCategory()) {
            case "City":
                tax = tax + City;
                break;
            case "Large town":
                tax = tax + LargeT;
                break;
            case "Small town":
                tax = tax + SmallT;
                break;
            case "Village":
                tax = tax + Village;
                break;
            case "Countryside":
                tax = tax + Countryside;
                break;
        }
        return tax;
    }
    public double isPrivateResidence(){
        if (!super.getPpr()){
            tax = tax + pprVal;
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
    public double getUpperBand() {
        return upperBand;
    }

    public void setUpperBand(double upperBand) {
        this.upperBand = upperBand;
    }

    public double getMiddleBand() {
        return middleBand;
    }

    public void setMiddleBand(double middleBand) {
        this.middleBand = middleBand;
    }

    public double getLowerBand() {
        return lowerBand;
    }

    public void setLowerBand(double lowerBand) {
        this.lowerBand = lowerBand;
    }
    public double getUpperBandPerc() {
        return upperBandPerc;
    }

    public void setUpperBandPerc(double upperBandPerc) {
        this.upperBandPerc = upperBandPerc;
    }

    public double getMiddleBandPerc() {
        return middleBandPerc;
    }

    public void setMiddleBandPerc(double middleBandPerc) {
        this.middleBandPerc = middleBandPerc;
    }

    public double getLowerBandPerc() {
        return lowerBandPerc;
    }

    public void setLowerBandPerc(double lowerBandPerc) {
        this.lowerBandPerc = lowerBandPerc;
    }
    public double getPenalty() {
        return penalty;
    }
    public void setPenalty(double penalty) {
        this.penalty = penalty;
    }
    public double getCity() {
        return City;
    }

    public void setCity(double city) {
        City = city;
    }

    public double getLargeT() {
        return LargeT;
    }

    public void setLargeT(double largeT) {
        LargeT = largeT;
    }

    public double getSmallT() {
        return SmallT;
    }

    public void setSmallT(double smallT) {
        SmallT = smallT;
    }

    public double getVillage() {
        return Village;
    }

    public void setVillage(double village) {
        Village = village;
    }

    public double getCountryside() {
        return Countryside;
    }

    public void setCountryside(double countryside) {
        Countryside = countryside;
    }
    public double getPprVal() {
        return pprVal;
    }

    public void setPprVal(double pprVal) {
        this.pprVal = pprVal;
    }
}
