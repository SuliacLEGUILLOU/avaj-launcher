
public interface IFlyable {
    /**
     * updateConction
     * Run the behavior associated to the weather
     */
    public void updateCondition();

    /**
     * Add the IFlyable object to the weather tower IFlyable list
     * @param tower to register to
     */
    public void registerTower(WeatherTower tower);

    public void printInfo();
}