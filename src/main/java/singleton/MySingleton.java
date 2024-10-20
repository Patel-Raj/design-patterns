package singleton;

/*
1. It allows creation of only one object
2. we can use keyword synchronized in getObject in case if multiple threads are trying to invoke getObject. This will ensure thread safety.
 */
public class MySingleton {
    int state;

    private static MySingleton mySingleton;

    private MySingleton(){
        this.state = 0;
    }

    public static MySingleton getObject() {
        if(mySingleton == null) {
            synchronized (MySingleton.class) {
                if(mySingleton == null) {
                    mySingleton = new MySingleton();
                }
            }
        }
        return mySingleton;
    }

    public void printState() {
        System.out.println("State: " + state);
    }

    public void increaseState() {
        this.state++;
    }
}
