package decorator;

public class Coffee extends Beverage {

    public Coffee(String desc) {
        this.desc = desc;
    }

    @Override
    public int cost() {
        return 10;
    }
}
