package slaw.electricity;

//JEST TO KLASA KTORA BEDZIE SLUZYLA DO TESTOWANIA METODY
//KTORA JEST ZALEZNA OD CZYNNIKOW ZEWNETRZNYCH

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class TariffElectricityMeterTest {

    ElectricityMeter electricityMeter;

    //po utworzeniu interfejsu i konstruktora
    TariffProvider tp;

    //ustalamy warunki poczatkowe adn JUnit
    //tutaj zapewniamy nowy licznik przed kazdym testem
    //ustawiamy booleana isTariffOn na true
    //ustawiamy tez godziny taryfy
    @Before
    public void setUp() {

        // po interfejsie i konstruktorze
        tp = Mockito.mock(TariffProvider.class);

        //i tu po dodaniu interfejsu i konstruktora damy tp
        electricityMeter = new ElectricityMeter(tp);

        electricityMeter.setTariffon(true);
        electricityMeter.setElectricityTariffStartHour(12);
        electricityMeter.setElectricityTariffEndtHour(14);

    }

    //beda ogolnie 2 testy, jeden na taryfie i jeden bez taryfy
    //taryfa bedzie ustawiana na obiekcie stworzonym tu w klasie testujacej
    // is tarif zasymulujemy na tru i false zaleznie od przypadku
    @Test
    public void givenOnTariffWhenKwhAdditionThenCounterTariffIsIncreased() {
        //Given z taryfa -- tutaj bedzie zaślepianie Mockito
        Mockito.when(tp.isTariffNow()).thenReturn(true);
//        Mockito.when(electricityMeter.isTariffNow()).thenReturn(true);
        //When
        electricityMeter.addKwh(100);
        //Then
        //oczekujemy 100, aktualny stan pokaze metoda, delta okresli dopuszczalny blad
        Assert.assertEquals(100, electricityMeter.getKwhTariff(), 0.01);
    }

    @Test
    public void givenNoOnTariffWhenKwhAdditionThenCounterIsIncreased() {
        //Given bez taryfy - tutaj bedzie zaslepianie Mockito
        Mockito.when(tp.isTariffNow()).thenReturn(false);
//        Mockito.when(electricityMeter.isTariffNow()).thenReturn(false);
        //When
        electricityMeter.addKwh(100);
        //Then
        //oczekujemy 100, aktualny stan pokaze metoda, delta okresli dopuszczalny blad
        Assert.assertEquals(100, electricityMeter.getKwh(), 0.01);
    }

    //OGOLNIE TA METODA ISTARIFFNOW POWINNA BYC ROZDZIELONA BO MA DWIE ODPOWIEDZIALNOSCI
    //PRZEZ TO JEST TROCHE CIEZKA DO SPRAWDZANIA ZMIANIMY JA UZYWAJAC INTERFEJSU
}
