package br.edu.geo;

import java.util.Objects;

public class Point {
    int latitude;
    int longitude;

    public Point(int latitude, int longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public Point calculateRange() {
        int modLatitude = this.latitude % 10;
        int modLongitude = this.longitude % 10;
        if(modLatitude > 5) {
            modLatitude-=5;
        }
        return new Point(this.latitude - modLatitude, this.longitude - modLongitude);
    }

    public boolean isRangePoint() {
        return this.latitude % 5 == 0 && this.longitude % 10 == 0;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return latitude == point.latitude && longitude == point.longitude;
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitude, longitude);
    }

    @Override
    public String toString() {
        return "point#latitude=" + latitude +
                "|longitude=" + longitude +
                "#";
    }
}
