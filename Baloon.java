
public class Baloon extends Aircraft implements IFlyable {
    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
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
                logger.log("The ground looks too close now...\n");
                if (this.coordinates.updateHeight(-15)) {
                    this.weatherTower.unregister(this);
                }
                break;
            case "RAIN":
                logger.log("that really doesn't sounds great...\n");
                if (this.coordinates.updateHeight(-5)) {
                    this.weatherTower.unregister(this);
                }
                break;
            case  "SUN":
                this.coordinates.updateHeight(4);
                this.coordinates.updateLongitude(10);
                logger.log("Let it go, Jack\n");
                break;
            case "FOG":
                logger.log("Did you see something ?\n");
                if (this.coordinates.updateHeight(-3)) {
                    this.weatherTower.unregister(this);
                }
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
