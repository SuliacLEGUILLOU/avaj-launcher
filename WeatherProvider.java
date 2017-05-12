
public class WeatherProvider {
    private String weather;

    private static WeatherProvider INSTANCE = new WeatherProvider();
    public static WeatherProvider getProvider() { return INSTANCE; }
    private WeatherProvider() {}

    public String getCurrentWeather(Coordinates coordinates) {
        switch ((coordinates.getHeight() % 4 + coordinates.getLatitude() % 4 + coordinates.getLongitude() % 4) % 4) {
            case 0:
                return "SNOW";
            case 1:
                return "SUN";
            case 2:
                return "FOG";
            case 3:
                return "RAIN";
            default:
                return "FROG";
        }
    }
}
