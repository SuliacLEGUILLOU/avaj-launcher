
public class JetPlane extends Aircraft implements IFlyable {
    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateCondition() {
        String weather = this.weatherTower.getWeather(this.coordinates);
        Logger logger = Logger.getLogger();

        this.printInfo();
        logger.log(": ");
        switch (weather) {
            case "SNOW":
                if (this.coordinates.updateHeight(-7)) {
                    this.weatherTower.unregister(this);
                }
                logger.log("We are gonna faaaaal\n");
                break;
            case "RAIN":
                this.coordinates.updateLatitude(7);
                logger.log("Singin' in the rain.\n");
                break;
            case  "SUN":
                this.coordinates.updateLongitude(2);
                if (this.coordinates.updateHeight(2)) {
                    this.weatherTower.unregister(this);
                }
                logger.log("Light, my only weakness...\n");
                break;
            case "FOG":
                this.coordinates.updateLatitude(1);
                logger.log("Can't fin my way home...\n");
                break;
            default:
                logger.log("What the hell is this ?\n");
        }
    }

    public void registerTower(WeatherTower tower) {
        tower.register(this);
        this.weatherTower = tower;
    }
}
