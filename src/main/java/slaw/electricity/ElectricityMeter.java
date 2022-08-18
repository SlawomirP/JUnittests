package slaw.electricity;

//zadania
//1 obliczanie kwh
//2 ustawianie taryf i stawek
//3 o ile drozszy jest prad poza taryfa
//4 narzedzie do ustawiania taryfy i stawki

public class ElectricityMeter {

    private float kwh = 0;
    private int centsForKwh = 0; // cena groszy za kwh

    private boolean tariffon = false; // flaga
    private float kwhTariff = 0; // kwh w ramach taryfy
    private int centsForKwhTariff = 0; // cena w taryfie

    private int electricityTariffStartHour = 0; // poczatek taryfy
    private int electricityTariffEndtHour = 0; // koniec taryfy
}
