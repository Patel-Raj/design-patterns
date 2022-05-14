package decorator;

/*
1. Decorates one object inside another.
2. Prefers composition over inheritance.
3. New decorators can be added without modifying the existing beverage class.
4. Existing classes should be closed for modification but open for extension.
5. Always program to an interface or abstract class, but not to a concrete class.
 */
public abstract class Beverage {
    String desc = "Unknown Beverage";

    public String getDescription() {
        return this.desc;
    }

    public abstract int cost();
}
