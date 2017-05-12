
public class AircraftFactory {
    public IFlyable newAirCraft(String type, String name, int longitude, int latitude, int heigth) {
        Coordinates coordinates = new Coordinates(longitude, latitude, heigth);

        switch (type) {
            case ("JetPlane"):
                return new JetPlane(name, coordinates);
            case ("Helicopter"):
                return new Helicopter(name, coordinates);
            case ("Baloon"):
                return new Baloon(name, coordinates);
        }
        return new JetPlane(name, coordinates); // may throw exeption here, but regex filter OP !
    }
}
