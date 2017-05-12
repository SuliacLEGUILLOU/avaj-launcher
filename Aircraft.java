
public class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    static private long idCounter = 0;

    Aircraft() {
        this.id = 0;
        this.name = "OVNI";
        this.coordinates = new Coordinates(100,100,100);
        idCounter = 9999999;
    }
    protected Aircraft(String name, Coordinates coordinates) {
        this.id = this.nextId();
        this.name = name;
        this.coordinates = coordinates;
    }
    private long nextId() {
        return (idCounter++);
    }
    public void printInfo() {
        Logger logger = Logger.getLogger();

        logger.log(this.getClass().getName() + "#" + this.name + "(" + this.id + ")");
    }
}
