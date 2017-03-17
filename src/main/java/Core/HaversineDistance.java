package Core;

import javafx.util.Pair;

public class HaversineDistance {

    // Returns distance between two points in meters
    public static Double getDistance(Pair<Double, Double> latlong1, Pair<Double, Double> latlong2) {
        final int R = 6371; // Radious of the earth
        Double latDistance = toRad(latlong2.getKey() - latlong1.getKey());
        Double lonDistance = toRad(latlong2.getValue() - latlong1.getValue());
        Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) +
                Math.cos(toRad(latlong1.getKey())) * Math.cos(toRad(latlong1.getKey())) *
                        Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        Double distance = R * c;

        return distance*1000;
    }

    private static Double toRad(Double value) {
        return value * Math.PI / 180;
    }

}