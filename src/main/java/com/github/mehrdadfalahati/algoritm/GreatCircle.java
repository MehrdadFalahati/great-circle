package com.github.mehrdadfalahati.algoritm;

public class GreatCircle {

    private GreatCircle() {}

    public static double calculate(double latitude, double longitude) {
        var latitudeFirst = Math.toRadians(CompanyLocation.LATITUDE);
        var longitudeFirst = Math.toRadians(CompanyLocation.LONGITUDE);
        var latitudeSecond = Math.toRadians(latitude);
        var longitudeSecond = Math.toRadians(longitude);

        double haversine = haversine(new Location(latitudeFirst, longitudeFirst), new Location(latitudeSecond, longitudeSecond));

        double radius = 6371;

        return haversine * radius;
    }

    private static double haversine(Location locationFirst, Location locationSecond) {
        double distanceLongitude = locationSecond.getLongitude() - locationFirst.getLongitude();
        double distanceLatitude = locationSecond.getLatitude() - locationFirst.getLatitude();
        double distance = Math.pow(Math.sin(distanceLatitude / 2), 2)
                + Math.cos(locationFirst.getLatitude()) * Math.cos(locationSecond.getLatitude())
                * Math.pow(Math.sin(distanceLongitude / 2),2);

        return 2 * Math.asin(Math.sqrt(distance));
    }

    private static class Location {
        private final double latitude;
        private final double longitude;

        public Location(double latitude, double longitude) {
            this.latitude = latitude;
            this.longitude = longitude;
        }

        public double getLatitude() {
            return latitude;
        }

        public double getLongitude() {
            return longitude;
        }
    }

    private static class CompanyLocation {
        public static final double LATITUDE = 35.776346;
        public static final double LONGITUDE = 51.413482;
    }
}
