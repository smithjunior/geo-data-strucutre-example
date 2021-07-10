package br.edu.geo;

interface IGeolocationService {
    void addPerson(String cpf, int latitude, int longitude);
    void updatePerson(String cpf, int latitude, int longitude);
    void removePerson(String cpf);
    String getFormatedRange(String cpf);
    int getCount(int latRangeStart, int lonRangeStart);
}
