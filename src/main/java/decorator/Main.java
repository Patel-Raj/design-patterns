package decorator;

public class Main {
    public static void main(String args[]) {
        Beverage myTea = new Tea("Tea");
        myTea = new MocaDecorator(myTea);
        myTea = new ChipsDecorator(myTea);
        System.out.println(myTea.getDescription() +  " => " + myTea.cost());
    }
}
