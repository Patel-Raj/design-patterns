package factorymethod;

import factorymethod.pizzastore.CAPizzaStore;
import factorymethod.pizzastore.NYPizzaStore;
import factorymethod.pizzastore.PizzaStore;

/*
1. This is called Factory Method design pattern.
2. Here the object creation is pushed to subclass which extends the factory.
3. This allows adding more types of pizzas without modifying the existing PizzaStore class.
4. So as per point #3 it's open to extension but closed for modification.
 */
public class Main {
    public static void main(String args[]) {
        PizzaStore nyPizzaStore = new NYPizzaStore();
        nyPizzaStore.orderPizza("cheese");
        PizzaStore caPizza = new CAPizzaStore();
        caPizza.orderPizza("veg");
    }
}
