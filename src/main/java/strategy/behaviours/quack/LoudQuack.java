package strategy.behaviours.quack;

public class LoudQuack implements QuackBehaviour{
    @Override
    public void quack() {
        System.out.println("Loud quacking!!");
    }
}
