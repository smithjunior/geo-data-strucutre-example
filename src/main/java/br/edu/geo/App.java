package br.edu.geo;

public class App 
{
    public static final String CPF_1 = "08487449425";
    public static final String CPF_2 = "1111111111";
    public static final String CPF_3 = "04040141010";
    public static final String CPF_4 = "12345678910";

    public static void main( String[] args )
    {
        IGeolocationService geolocationService = new GeolocationService();

        geolocationService.addPerson(CPF_1,15,78);
        geolocationService.addPerson(CPF_2,15,72);
        geolocationService.addPerson(CPF_3,15,72);
        geolocationService.addPerson(CPF_4,6,10);

        geolocationService.updatePerson(CPF_1,15,73);

        geolocationService.removePerson(CPF_2);

        String formatedRange = geolocationService.getFormatedRange(CPF_1);
        System.out.println("point: "+formatedRange);

        int totalItemsRange = geolocationService.getCount(15,70);
        System.out.println(totalItemsRange);
    }
}
