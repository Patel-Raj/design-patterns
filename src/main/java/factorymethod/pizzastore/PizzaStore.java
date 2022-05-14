package factorymethod.pizzastore;

import factorymethod.pizza.Pizza;

public abstract class PizzaStore {

    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);
        pizza.prepare();
        pizza.box();
        return pizza;
    }

    public abstract Pizza createPizza(String type);
}
