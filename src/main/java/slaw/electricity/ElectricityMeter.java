package slaw.electricity;

//zadania
//1 obliczanie kwh
//2 ustawianie taryf i stawek
//3 o ile drozszy jest prad poza taryfa
//4 narzedzie do ustawiania taryfy i stawki

import java.util.Calendar;

public class ElectricityMeter {

    private float kwh = 0;
    private int centsForKwh = 0; // cena groszy za kwh

    private boolean tariffon = false; // flaga
    private float kwhTariff = 0; // kwh w ramach taryfy
    private int centsForKwhTariff = 0; // cena w taryfie

    private int electricityTariffStartHour = 0; // poczatek taryfy
    private int electricityTariffEndtHour = 0; // koniec taryfy

    //dodanie kwh
    public void addKwh(float kwhToAdd){
        if(isTariffNow()){
            //dodanie kwh pod warunkiem taryfy
            kwhTariff += kwhToAdd;
        }else {
            //dodanie kwh bez taryfy
            kwh += kwhToAdd;
        }
    }
    //napisanie metody sprawdzajacej czy jest taryfa
    private boolean isTariffNow(){
        //pobierze aktualna date !!!!!!
        Calendar rightNow = Calendar.getInstance();
        //nastepnie z tego wyciagamy godzine
        int hour = rightNow.get(Calendar.HOUR_OF_DAY);
        //zwroc czy hour jest miedzy godzinami taryfy
        return hour > electricityTariffStartHour && hour < electricityTariffEndtHour;
    }

    //o ile jest drozszy prad poza taryfa, koment do java doc

    /**
     *
     * @return how much more expensive is normal price comparing
     * to tariff in percentages
     */
    public int getHowMoreExpensiveNormalIs(){
        return (centsForKwh * 100 / centsForKwhTariff) - 100;
    }
//settery do ustawiania ale one maja byc dostepne tylko w tym pakiecie
    //dlatego usuwamy public
    void setCentsForKwh(int centsForKwh) {
        this.centsForKwh = centsForKwh;
    }

    void setTariffon(boolean tariffon) {
        this.tariffon = tariffon;
    }

    void setCentsForKwhTariff(int centsForKwhTariff) {
        this.centsForKwhTariff = centsForKwhTariff;
    }

    void setElectricityTariffStartHour(int electricityTariffStartHour) {
        this.electricityTariffStartHour = electricityTariffStartHour;
    }

    void setElectricityTariffEndtHour(int electricityTariffEndtHour) {
        this.electricityTariffEndtHour = electricityTariffEndtHour;
    }
}
