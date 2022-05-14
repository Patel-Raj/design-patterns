package decorator;

public class MocaDecorator extends CondimentDecorator{
    Beverage beverage;

    public MocaDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return this.beverage.getDescription() + ", " + "Moca";
    }

    @Override
    public int cost() {
        return this.beverage.cost() + 1;
    }
}
