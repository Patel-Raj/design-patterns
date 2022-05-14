package factorymethod.pizza;


public abstract class Pizza {
    String name;

    public void prepare() {
        System.out.println("Preparing pizza  " + name);
    }
    public void cut() {
        System.out.println("Cutting diagonally");
    }
    public void box() {
        System.out.println("Placing in official pizza boxes");
    }
}
