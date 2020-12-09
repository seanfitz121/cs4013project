public class TestManagement {
    public static void main(String[] args){
        Management Doe = new Management();
        TestOwner test = new TestOwner();
        test.testPassedOwner(Doe.registerOwner("Sam"));
        Doe.getPropertyTax("V94WCV9");
    }
}
