package lld.cloakroom;


/*
3. Each room will have racks
4. Each rack will have collection of lockers
5. Each room will have 2 person (Clerk and helper)
6. Items can be small, medium and large (so does the locker)
7. Token enquireLocker(Item, submission_time, personId, Mobile number, Identity proof)
8. Token (Token number, Locker number, submission_time)
9. Payment generated based on item size and duration of storage.

=> Assign the nearest locker.
 */




import java.util.Date;
import java.util.List;

class Person {

}

public class CloakRoom {
    private List<Rack> racks;
    private Person clerk;
    private Person helper;
    static int totalRacks = 10;

    public CloakRoom(Person clerk, Person helper) {
        this.clerk = clerk;
        this.helper = helper;
        for(int i = 0 ; i < totalRacks; i++) {
            racks.add(new Rack());
        }
    }

    public Token requestLocker(Item item, Person person) {
        Locker smallLocker = null;
        Locker mediumLocker = null;
        Locker largeLocker = null;
        Locker allocatedLocker = null;
        for(Rack rack : racks) {
            for(Locker locker : rack.lockers) {
                if (smallLocker == null && locker.getLockerType().lockerSize == LockerSize.SMALL) {
                    smallLocker = locker;
                }
                if (mediumLocker == null && locker.getLockerType().lockerSize == LockerSize.MEDIUM) {
                    mediumLocker = locker;
                }
                if (largeLocker == null && locker.getLockerType().lockerSize == LockerSize.LARGE) {
                    largeLocker = locker;
                }
                if(smallLocker != null && mediumLocker != null && largeLocker != null)
                    break;
            }
        }
        // Implement further logic
        return null;
    }

    public Receipt processReturn(Token token) {
        return null;
    }

    public static void main(String[] args) {

    }

}

enum PaymentType {
    CREDIT, DEBIT, CASH;
}

class Payment {
    PaymentType paymentType;
    Date paymentDate;
    double amount;
}

class Receipt {
    int receiptNumber;
    Payment paymentDetails;
    int lockerNumber;
    Date entryDate;
    Date exitDate;
    LockerType lockerType;
}

class Token {
    private int lockerNumber;
    private Date entryDate;
    private Date exitDate;
}

class Item {
    private String name;
    private String description;
    private LockerSize itemSize;

    public LockerSize getItemSize() {
        return this.itemSize;
    }
}

class Rack {
    List<Locker> lockers;
    static int maxCapacity = 100;

    public Rack() {
        maxCapacity =  100;
    }
}

abstract class LockerType {
    LockerSize lockerSize;
    double costPerHour;

    public double getCostPerHour() {
        return costPerHour;
    }
}

enum LockerSize {
    SMALL, MEDIUM, LARGE, NONE;
}

class SmallLocker extends LockerType {

    public SmallLocker() {
        this.lockerSize = LockerSize.SMALL;
        this.costPerHour = 10;
    }

}

class MediumLocker extends LockerType {

    public MediumLocker() {
        this.lockerSize = LockerSize.MEDIUM;
        this.costPerHour = 20;
    }
}

enum LockerState {
    EMPTY, OCCUPIED;
}

class Locker {
    private int lockerNumber;
    private LockerType lockerType;
    private LockerState lockerState;
    private Item item;

    public Locker(int lockerNumber, LockerType lockerType, LockerState lockerState, Item item) {
        this.lockerNumber = lockerNumber;
        this.lockerType = lockerType;
        this.lockerState = lockerState;
        this.item = null;
    }

    public boolean isEmpty() {
        return lockerState == LockerState.EMPTY;
    }

    public  LockerType getLockerType() {
        return this.lockerType;
    }
}
