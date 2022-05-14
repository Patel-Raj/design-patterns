package decorator;

public class ChipsDecorator extends CondimentDecorator{
    Beverage beverage;

    public ChipsDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return this.beverage.getDescription() + ", " + "choco chips";
    }

    @Override
    public int cost() {
        return 2 + this.beverage.cost();
    }
}
