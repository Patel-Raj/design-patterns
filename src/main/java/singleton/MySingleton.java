package singleton;

/*
1. It allows creation of only one object
2. we can use keyword synchronized in getObject in case if multiple threads are trying to invoke getObject. This will ensure thread safty.
 */
public class MySingleton {

    private static MySingleton mySingleton;

    private MySingleton(){

    }

    public static MySingleton getObject() {
        if(mySingleton == null) {
            mySingleton = new MySingleton();
        }
        return mySingleton;
    }

    public void printIt() {
        System.out.println("This is MySingleton");
    }
}
