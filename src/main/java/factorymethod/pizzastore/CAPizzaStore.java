package factorymethod.pizzastore;

import factorymethod.pizza.CAStyleVegPizza;
import factorymethod.pizza.NYStyleCheesePizza;
import factorymethod.pizza.Pizza;

public class CAPizzaStore extends PizzaStore{
    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if(type == "veg")
            pizza = new CAStyleVegPizza();
        else if(type == "butter")
            pizza = null;
        return pizza;
    }
}
