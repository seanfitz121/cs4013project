import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Management
{
    private ArrayList<Owner> owners = new ArrayList<>();
    public Management(){
    }
    public Owner registerOwner(String name){
        Owner o = new Owner(name);
        owners.add(o);
        return o;
    }
    public void getPropertyTaxFromEircode(String eircode){
        String row;
        BufferedReader csvReader = null;
        System.out.println("Property tax for Eircode:" + eircode);
        try {
            csvReader = new BufferedReader(new FileReader("record.csv"));
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                for(int i = 0; i < data.length; i++){
                    if (data[i].equals(eircode)) {
                        System.out.println(data[i] + " " + data[i + 1] + " " + data[i + 2] + " " + data[i + 3]);
                    }
                }
            }
            System.out.println();
            csvReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void getPropertyTaxFromOwner(String name){
        String row;
        BufferedReader csvReader = null;
        System.out.println("Property tax for " + name);
        for(int y = 0; y < owners.size(); y++) {
            Owner o = owners.get(y);
            if (o.getName().equals(name)) {
                for(int x = 0; x < o.getProperties().size(); x++) {
                    String eircode = o.getProperties().get(x).getEircode();
                    try {
                        csvReader = new BufferedReader(new FileReader("record.csv"));
                        while ((row = csvReader.readLine()) != null) {
                            String[] data = row.split(",");
                            for (int i = 0; i < data.length; i++) {
                                if (data[i].equals(eircode)) {
                                    System.out.println(data[i] + " " + data[i + 1] + " " + data[i + 2] + " " + data[i + 3]);
                                }
                            }
                        }
                        csvReader.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        System.out.println();
    }
    public void getOverdueTaxForYear(int year){
        for(int i = 0; i < owners.size(); i++){
            System.out.println("Taxes Overdue for " + owners.get(i).getName() + " in " + year +":");
            owners.get(i).viewOverdueTax(year);
        }
    }
    public void getOverdueTaxForYear(String routKey, int year){
        for(int i = 0; i < owners.size(); i++){
            System.out.println("Taxes Overdue for " + owners.get(i).getName() + " in " + routKey +":");
            owners.get(i).viewOverdueTax(routKey, year);
        }
    }
    public void getStats(String routKey){
        double totalTax = getTotalTax(routKey);
        System.out.println(totalTax);
        double[] avgAndAmount = new double[2];
        avgAndAmount = getAverageAndAmount(routKey);
        double averageTax = avgAndAmount[0];
        System.out.println(averageTax);
        int number = (int)avgAndAmount[1];
        System.out.println(number);
        double percentage = getPercentage(routKey, number);
        System.out.println(percentage);
    }
    private double getTotalTax(String routKey){
        //Total Tax Paid for Area
        double totalTax = 0;
        String row;
        BufferedReader csvReader = null;
        System.out.println("Total tax for " + routKey);
        for(int y = 0; y < owners.size(); y++) {
            Owner o = owners.get(y);
            try {
                csvReader = new BufferedReader(new FileReader("record.csv"));
                while ((row = csvReader.readLine()) != null) {
                    String[] data = row.split(",");
                    for (int i = 0; i < data.length; i++) {
                        if (data[i].substring(0,3).equals(routKey)) {
                            totalTax = totalTax + Double.parseDouble(data[i+1]);
                        }
                    }
                }
                csvReader.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return totalTax;
    }
    private double[] getAverageAndAmount(String routKey){
        //Total Tax Paid for Area
        double averageTax = 0;
        ArrayList<Double> numbers = new ArrayList<>();
        String row;
        BufferedReader csvReader = null;
        System.out.println("Average tax for " + routKey);
        for(int y = 0; y < owners.size(); y++) {
            Owner o = owners.get(y);
            try {
                csvReader = new BufferedReader(new FileReader("record.csv"));
                while ((row = csvReader.readLine()) != null) {
                    String[] data = row.split(",");
                    for (int i = 0; i < data.length; i++) {
                        if (data[i].substring(0,3).equals(routKey)) {
                            numbers.add(Double.parseDouble(data[i+1]));
                        }
                    }
                }
                csvReader.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        int count = 0;
        for(int i = 0; i < numbers.size(); i++, count++){
            averageTax = averageTax + numbers.get(i);
        }
        return new double[]{averageTax / count, count};
    }
    private double getPercentage(String routKey, int count){
        int amount = 0;
        for(int i = 0; i < owners.size(); i++){
            for(int j = 0; j < owners.get(i).getProperties().size(); j++) {
                Property p = owners.get(i).getProperties().get(j);
                if(p.getEircode().substring(0,3).equals(routKey)){
                    amount = amount + p.getTaxHistory().size();
                }
            }
        }
        System.out.println(amount);
        return (((double)count)/((double)amount))*100;
    }
    public ArrayList<Owner> getOwners(){
        return this.owners;
    }
}
