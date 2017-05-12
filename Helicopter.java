

public class Helicopter extends Aircraft implements IFlyable {
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
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
                logger.log("We are gonna faaaaall !\n");
                if (this.coordinates.updateHeight(-12)) {
                    this.weatherTower.unregister(this);
                }
                break;
            case "RAIN":
                this.coordinates.updateLongitude(5);
                logger.log("Spluuuuuuuche...\n");
                break;
            case  "SUN":
                this.coordinates.updateHeight(2);
                this.coordinates.updateLongitude(10);
                logger.log("Here come the sun, tulululu...\n");
                break;
            case "FOG":
                this.coordinates.updateLongitude(1);
                logger.log("TOOOOOOOOOOOOT !\n");
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
