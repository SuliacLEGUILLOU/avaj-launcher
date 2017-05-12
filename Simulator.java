
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.*;

public class Simulator { // Packagin

    public static void main(String[] args) {
        AircraftFactory factory = new AircraftFactory();
        WeatherTower weatherTower;
        List<String> lines = null;
        IFlyable flyable;
        Logger logger = Logger.getLogger();
        int iteration = 0;

        try {
            lines = Files.readAllLines(Paths.get(args[0]), StandardCharsets.UTF_8);
        } catch (IOException ioException) {
            System.out.print("File not found");
            System.exit(1);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.print("Not enougth minerals");
            System.exit(1);
        }
        if (lines != null && lines.size() > 0) {
            weatherTower = new WeatherTower(lines.size());
            try {
                iteration = Integer.parseInt(lines.remove(0));    // This is bad : need try catch
            } catch (Exception e) {
                System.out.println("Error reading simulation option");
                System.exit(1);
            }
            Pattern pattern = Pattern.compile("^((?:Baloon)|(?:JetPlane)|(?:Helicopter)) (.+?) ([0-9]+) ([0-9]+) ([0-9]+)$");

            for (String line: lines) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    flyable = factory.newAirCraft(
                            matcher.group(1),
                            matcher.group(2),
                            Integer.parseInt(matcher.group(3)),
                            Integer.parseInt(matcher.group(4)),
                            Integer.parseInt(matcher.group(5))
                    );
                    flyable.registerTower(weatherTower);
                } else if (!line.isEmpty()){
                    System.err.println("Error reading line : " + line);
                    System.exit(1);
                }
            }

            for (int i = 0; i < iteration; i++) {
                weatherTower.changeWeather();
            }
            logger.write();
            System.out.println("Simultation done. Open the simulation.txt for results");
        }
    }
}
