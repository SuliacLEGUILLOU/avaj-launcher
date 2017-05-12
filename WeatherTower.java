
public class WeatherTower extends Tower {
    WeatherTower(int size){
        super(size);
    }
    public String getWeather(Coordinates coordinates) {
        WeatherProvider weatherProvider = WeatherProvider.getProvider();

        return weatherProvider.getCurrentWeather(coordinates);
    }
    void changeWeather() {
        this.conditionChanged();
    }
}