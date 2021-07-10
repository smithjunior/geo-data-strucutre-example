package br.edu.geo;

public class App 
{
    public static void main( String[] args )
    {
        IGeolocationService geolocationService = new GeolocationService();

        geolocationService.addPerson("08487449425",15,78);
        geolocationService.addPerson("1111111111",15,72);
        geolocationService.addPerson("04040141010",15,72);
        geolocationService.addPerson("12345678910",6,10);

        geolocationService.updatePerson("08487449425",15,73);

        geolocationService.removePerson("1111111111");

        String formatedRange = geolocationService.getFormatedRange("08487449425");
        System.out.println("point: "+formatedRange);

        int totalItemsRange = geolocationService.getCount(15,70);
        System.out.println(totalItemsRange);
    }
}
