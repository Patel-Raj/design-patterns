package strategy;

import strategy.behaviours.fly.FlyWithWings;
import strategy.behaviours.quack.LoudQuack;
import strategy.constant.Duck;
import strategy.constant.MallardDuck;

public class main {
    public static void main(String args[]) {
        Duck duck = new MallardDuck();
        duck.setFlyBehaviour(new FlyWithWings());
        duck.setQuackBehaviour(new LoudQuack());

        duck.performFly();
        duck.performQuack();
    }
}
