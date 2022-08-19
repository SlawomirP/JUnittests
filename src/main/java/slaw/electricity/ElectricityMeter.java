package slaw.electricity;


import java.util.Calendar;

public class ElectricityMeter {

    //TWORZYMY INTERFEJS KTORY POZWOLI NAM ROZDZIELIC
    //ODPOWIEDZIALNOSC METODI ISTARIFFNOW BO ONA ROBI
    //ZA DUZO, TU JEGO POLE

    TariffProvider tp;

    //PO STWORZENIU INTERFEJSU TWORZYMY 2 KONSTRUKTORY
    //JEDEN PUSTY A DRUGI BEDZIE WSTRZYKIWAL INTERFEJS
    //DZIEKI TEMU DRUGIEMU UZYSKAMY POLE KTORE ZASTOSUJEMY
    //W METODZIE ISTARIFFNOW

    public ElectricityMeter(TariffProvider tp) {
        this.tp = tp;
    }

    public ElectricityMeter() {
        tp = new TariffProvider() {
            @Override
            public boolean isTariffNow() {
                Calendar rightNow = Calendar.getInstance();
                int hour = rightNow.get(Calendar.HOUR_OF_DAY);
                return hour > electricityTariffStartHour && hour < electricityTariffEndtHour;
            }
        };
    }

    private float kwh = 0;
    private int centsForKwh = 0; // cena groszy za kwh

    private boolean tariffon = false; // flaga
    private float kwhTariff = 0; // kwh w ramach taryfy
    private int centsForKwhTariff = 0; // cena w taryfie

    private int electricityTariffStartHour = 0; // poczatek taryfy
    private int electricityTariffEndtHour = 0; // koniec taryfy

    //dodanie kwh
    public void addKwh(float kwhToAdd) {
        if (isTariffNow()) {
            kwhTariff += kwhToAdd;
        } else {
            kwh += kwhToAdd;
        }
    }

    public boolean isTariffNow() {
        return tp.isTariffNow();
    }

    /**
     * @return how much more expensive is normal price comparing
     * to tariff in percentages
     */
    public int getHowMoreExpensiveNormalIs() {
        return (centsForKwh * 100 / centsForKwhTariff) - 100;
    }

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

    public float getKwh() {
        return kwh;
    }

    public void reset() {
        this.kwh = 0;
        this.centsForKwh = 0;

        this.tariffon = false;
        this.kwhTariff = 0;
        this.centsForKwhTariff = 0;

        this.electricityTariffStartHour = 0;
        this.electricityTariffEndtHour = 0;
    }

    public float getKwhTariff() {
        return kwhTariff;
    }
}
