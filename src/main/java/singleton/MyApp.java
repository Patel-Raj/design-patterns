package singleton;

public class MyApp {
    public static void main(String args[]) {
        MySingleton obj = MySingleton.getObject();
        obj.printIt();
    }
}
