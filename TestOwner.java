
public class TestOwner
{
    public TestOwner(){
    }
    public void testPassedOwner(Owner Sam){
        Property LK = new Property("19 Cul Crannagh", "V94WCV9", 1000, "City", true, 2018);
        //Property L = new Property("1 Fedamore", "V94KL01", 500, "Village", true, 2015);
        //Property WE = new Property("18 Darrowton", "V94Y2VD", 2000, "Countryside", false, 2017);
        Sam.registerProperty(LK);
        //Sam.registerProperty(L);
        //Sam.registerProperty(WE);
        Sam.viewProperties();
        Sam.viewPaidTax();
        Sam.payTax(LK, 2020);
        Sam.payTax(LK, 2018);
        Sam.viewPaidTax();
        Sam.viewDueTax();
        Sam.viewOverdueTax();
        Sam.balancingStatement(2020);
        Sam.balancingStatement(LK);
    }
}
