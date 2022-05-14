package factorymethod.pizzastore;

import factorymethod.pizza.NYStyleCheesePizza;
import factorymethod.pizza.Pizza;

public class NYPizzaStore extends PizzaStore{

    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if(type == "cheese")
            pizza = new NYStyleCheesePizza();
        else if(type == "butter")
            pizza = null;
        return pizza;
    }
}
