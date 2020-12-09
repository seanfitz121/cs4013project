import java.io.IOException;
import java.util.Scanner;

public class CLI {
    private Scanner in;
    Management m = new Management();
    boolean loggedIn;
    boolean managerLoggedIn;
    String currentUser;
    int index = 0;

    /**
     * Constructs CLI object
     */
    public CLI() {
        in = new Scanner(System.in);
    }

    /**
     * Runs the cmd login interface
     */
    public void run() throws IOException {
        ImportData data = new ImportData(m);
        System.out.println("Are you a 1)Manager 2)Owner?");
        String command = in.nextLine().toUpperCase();
        if(command.equals("1")){
            managerLoggedIn = true;
            while(managerLoggedIn){
                System.out.println("\n1)List Owners 2)List Properties");
                System.out.println("3)Get Property Payment Data, 4)Get Owner Payment Data,");
                System.out.println("5)List Overdue Tax, 6)Get Property Tax Statistics,");
                System.out.println("7)Tweak rates or levies, E)xit");
                command = in.nextLine().toUpperCase();
                if(command.equals("1")){
                    for(int i = 0; i < m.getOwners().size(); i++){
                        System.out.println(m.getOwners().get(i).getName());
                    }
                }
                if(command.equals("2")){
                    for(int i = 0; i < m.getOwners().size(); i++){
                        System.out.println(m.getOwners().get(i).viewProperties());
                    }
                }
                if(command.equals("3")){
                    System.out.println("Please enter property eircode: ");
                    String eircode = in.nextLine();
                    for(int i = 0; i < m.getOwners().size(); i++){
                        for(int j = 0; j < m.getOwners().get(i).getProperties().size(); j++){
                            if(m.getOwners().get(i).getProperties().get(j).getEircode().equals(eircode)){
                                System.out.println(m.getOwners().get(i).balancingStatement(m.getOwners().get(i).getProperties().get(j)));
                            }
                        }
                    }
                }
                if(command.equals("4")){
                    System.out.println("Please enter Owner name: ");
                    String name = in.nextLine();
                    for(int i = 0; i < m.getOwners().size(); i++){
                        if(m.getOwners().get(i).getName().equals(name)){
                            System.out.println(m.getOwners().get(i).viewPaidTax());
                            System.out.println(m.getOwners().get(i).viewDueTax());
                            System.out.println(m.getOwners().get(i).viewOverdueTax());
                        }
                    }
                }
                if(command.equals("5")){
                    System.out.println("Please enter Owner name: ");
                    String name = in.nextLine();
                    for(int i = 0; i < m.getOwners().size(); i++){
                        if(m.getOwners().get(i).getName().equals(name)){
                            System.out.println(m.getOwners().get(i).viewOverdueTax());
                        }
                    }
                }
                if(command.equals("6")){
                    System.out.println("Please enter routing key: ");
                    String key = in.nextLine();
                    System.out.println(m.getStats(key));
                }
                if(command.equals("7")){

                }
                if(command.equals("E")){
                    return;
                }
            }
        }
        System.out.println("Would you like to: 1)Register 2)Sign In E)xit");
        command = in.nextLine().toUpperCase();
        if(command.equals("1")){
            System.out.println("Please enter your name: ");
            command = in.nextLine();
            m.registerOwner(command);
            System.out.println("Registered User: " + command);
            for (int i = 0; i < m.getOwners().size(); i++) {
                if (m.getOwners().get(i).getName().equals(command)) {
                    index = i;
                }
            }
        }
        if(command.equals("2")) {
            System.out.println("Please enter your name: ");
            currentUser = in.nextLine();
            for (int i = 0; i < m.getOwners().size(); i++) {
                if (m.getOwners().get(i).getName().equals(currentUser)) {
                    index = i;
                }
            }
            if (index == -1) {
                System.out.println("Error must register before signing in.");
            }
        }
        if(command.equals("E")){
            return;
        }
        boolean more = true;
        loggedIn = true;
        while (loggedIn) {
            /* Owner Commands*/
                System.out.println("\n1)Register Property, 2)View Properties, 3)Pay Tax,");
                System.out.println("4)View Paid Tax, 5)View Due Tax, 6)View Overdue Tax,");
                System.out.println("7)View Balancing Statements, 8)Payment History, E)xit");
                command = in.nextLine().toUpperCase();
                if (command.equals("1")) {
                    System.out.println("Please enter Address: ");
                    String address = in.nextLine();
                    System.out.println("Please enter Eircode: ");
                    String eircode = in.nextLine();
                    System.out.println("Please enter Market Value: ");
                    double value = Double.valueOf(in.nextLine());
                    System.out.println("Please enter the Location Category: ");
                    String locationCategory = in.nextLine();
                    System.out.println("Is this property a private residence? Please enter TRUE or FALSE: ");
                    boolean ppr = Boolean.valueOf(in.nextLine());
                    System.out.println("Please enter Year: ");
                    int year = Integer.valueOf(in.nextLine());
                    m.getOwners().get(index).registerProperty(address, eircode, value, locationCategory, ppr, year);
                }
                if (command.equals("2")) {
                    m.getOwners().get(index).viewProperties();
                }
                if(command.equals("3")){
                    System.out.println("Please enter the Eircode of Property:");
                    String eircode = in.nextLine();
                    System.out.println("Please enter the Tax Year you are paying:");
                    int year = Integer.valueOf(in.nextLine());
                    int tempIndex = 0;
                    for(int i = 0; i < m.getOwners().get(index).getProperties().size(); i++){
                        if(m.getOwners().get(index).getProperties().get(i).getEircode().equals(eircode)){
                            tempIndex = i;
                        }
                    }
                    m.getOwners().get(index).payTax(m.getOwners().get(index).getProperties().get(tempIndex), year);
                    System.out.println("Payment Successful.");
                }
                if(command.equals("4")){
                    System.out.println(m.getOwners().get(index).viewPaidTax());
                }
                if(command.equals("5")){
                    System.out.println(m.getOwners().get(index).viewDueTax());
                }
                if(command.equals("6")){
                    System.out.println(m.getOwners().get(index).viewOverdueTax());
                }
                if(command.equals("7")){
                    System.out.println("Please enter Year:");
                    int temp = Integer.valueOf(in.nextLine());
                    System.out.println(m.getOwners().get(index).balancingStatement(temp));
                }
                if(command.equals("8")){
                    m.getOwners().get(index).getPayments();
                }
                if(command.equals("E")){
                    break;
                }

            if(command.equals("E")){
                break;
            }
        }
    }
}
