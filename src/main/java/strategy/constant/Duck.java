package strategy.constant;

/*
1. strategy design pattern separates the behaviour that will change from the behaviour that is constant.
2. A behaviour is encapsulated in a set of interface and its implementation classes.
3. Those interfaces are then composed in the the client classes which uses those behaviours implemented by implementation classes.
4. has-a is preferred over is-a (composition is preferred over inheritance)
 */

import strategy.behaviours.fly.FlyBehaviour;
import strategy.behaviours.quack.QuackBehaviour;

public abstract class Duck {
    private FlyBehaviour flyBehaviour;
    private QuackBehaviour quackBehaviour;

    public void swim() {
        System.out.println("I can swim");
    }

    public void performFly() {
        flyBehaviour.fly();
    }

    public void performQuack() {
        quackBehaviour.quack();
    }

    public abstract void display();

    public FlyBehaviour getFlyBehaviour() {
        return flyBehaviour;
    }

    public void setFlyBehaviour(FlyBehaviour flyBehaviour) {
        this.flyBehaviour = flyBehaviour;
    }

    public QuackBehaviour getQuackBehaviour() {
        return quackBehaviour;
    }

    public void setQuackBehaviour(QuackBehaviour quackBehaviour) {
        this.quackBehaviour = quackBehaviour;
    }
}
