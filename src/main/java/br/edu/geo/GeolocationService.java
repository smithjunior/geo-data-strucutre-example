package br.edu.geo;

import java.util.*;

public class GeolocationService implements IGeolocationService{
    Comparator<Point> comparator = (ele1, ele2) -> {
        return ele1.toString().compareTo(ele2.toString());
    };

    HashMap<String, Point> tableHashPersonPoints = new HashMap<>();
    TreeMap<Point, HashSet<String>> treeMapRangePoints= new TreeMap<>(comparator);

    @Override
    public void addPerson(String cpf, int latitude, int longitude) {
        assert cpf != null;

        if (null != this.tableHashPersonPoints.get(cpf)) {
            throw new RuntimeException("CPF already persistence in hash table!");
        }
        Point point = new Point(latitude, longitude);
        HashSet<String> hashSet = this.treeMapRangePoints.get(point.calculateRange());

        if( null == hashSet) {
            hashSet = new HashSet<>();
        }

        hashSet.add(cpf+point.toString());

        this.treeMapRangePoints.put(point.calculateRange(), hashSet);

        this.tableHashPersonPoints.put(cpf, point) ;

    }

    @Override
    public void updatePerson(String cpf, int latitude, int longitude) {
        assert cpf != null;
        Point point = this.tableHashPersonPoints.get(cpf);
        if (null == point) {
            throw new RuntimeException("CPF not found in hash table, please insert before invoke this method!");
        }
        Point newPoint = new Point(latitude, longitude);

        HashSet<String> hashSet = this.treeMapRangePoints.get(point.calculateRange());
        hashSet.remove(cpf+point.toString());

        hashSet.add(cpf+newPoint.toString());

        this.tableHashPersonPoints.put(cpf, newPoint );
    }

    @Override
    public void removePerson(String cpf) {
        Point point = this.tableHashPersonPoints.get(cpf);
        HashSet<String> hashSet = this.treeMapRangePoints.get(point.calculateRange());
        hashSet.remove(cpf+point.toString());
        this.tableHashPersonPoints.remove(cpf);
    }

    @Override
    public String getFormatedRange(String cpf) {
        assert cpf != null;

        Point point = this.tableHashPersonPoints.get(cpf);
        if (null == point) {
            throw new RuntimeException("CPF not found in hash table!");
        }

        return point.getLatitude() + "?? " + point.getLongitude() + "??";
    }

    @Override
    public int getCount(int latRangeStart, int lonRangeStart) {
        Point point = new Point(latRangeStart, lonRangeStart);
        if (!point.isRangePoint()){
            throw new RuntimeException("Is not a range point!");
        }
        HashSet<String> hashSet = this.treeMapRangePoints.get(point.calculateRange());
        return hashSet.size();
    }
}
