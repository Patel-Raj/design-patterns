package decorator;

public class Tea extends Beverage{

    public Tea(String desc) {
        this.desc = desc;
    }

    @Override
    public int cost() {
        return 20;
    }
}
