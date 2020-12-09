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
    public void getPropertyTax(String eircode){
        String row;
        BufferedReader csvReader = null;
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
            csvReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Owner> getOwners(){
        return this.owners;
    }
}
