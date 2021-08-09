package com.sda.goldmann.iss.util;

public final class SpeedCalculator {

    private static final double SECONDS_IN_HOUR = 3600d;

    private SpeedCalculator() {
    }

    public static double distance(float lat1, float lon1, float lat2, float lon2, String unit) {
        if ((lat1 == lat2) && (lon1 == lon2)) {
            return 0;
        }

        double theta = lon1 - lon2;
        double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2))
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
        dist = Math.acos(dist);
        dist = Math.toDegrees(dist);
        dist = dist * 60 * 1.1515;

        if (unit.equals("K")) {
            dist = dist * 1.609344;
        } else if (unit.equals("N")) {
            dist = dist * 0.8684;
        }

        return (dist);
    }

    public static double speed(double distanceInKilometers, long timeInSeconds) {
        return distanceInKilometers / (timeInSeconds / SECONDS_IN_HOUR);
    }

}
