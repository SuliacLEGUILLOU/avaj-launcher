
public abstract class Tower {   // This class should be re-write from scratch with a hash-table
    private IFlyable[] observer;
    private int numFly;
    private Boolean[] registered;

    Tower(int size) {
        this.numFly = 0;
        this.observer = new IFlyable[size + 1];
        this.registered = new Boolean[size + 1];
    }
    public void register(IFlyable flyable) {
        Logger logger = Logger.getLogger();

        this.observer[numFly] = flyable;
        this.registered[numFly] = true;
        this.numFly++;
        logger.log("Tower says: ");
        flyable.printInfo();
        logger.log(" registered to weather tower.\n");
    }
    public void unregister(IFlyable flyable) {
        Logger logger = Logger.getLogger();

        for (int i = 0; i < this.numFly; i++) {
            if (observer[i] == flyable) {
                this.registered[i] = false;
                break;
            }
        }
        logger.log("Tower says: ");
        flyable.printInfo();
        logger.log(" unregistered to weather tower.\n");
    }
    protected void conditionChanged() {
        for (int i = 0; i < numFly; ++i) {
            if (registered[i]) {
                observer[i].updateCondition();
            }
        }
    }
}
