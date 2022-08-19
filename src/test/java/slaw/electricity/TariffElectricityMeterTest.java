package slaw.electricity;

//JEST TO KLASA KTORA BEDZIE SLUZYLA DO TESTOWANIA METODY
//KTORA JEST ZALEZNA OD CZYNNIKOW ZEWNETRZNYCH

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class TariffElectricityMeterTest {

    ElectricityMeter electricityMeter;

    //ustalamy warunki poczatkowe adn JUnit
    //tutaj zapewniamy nowy licznik przed kazdym testem
    //ustawiamy booleana isTariffOn na true
    //ustawiamy tez godziny taryfy
    @Before
    public void setUp(){
        electricityMeter = new ElectricityMeter();
        //trzeba to dodac aby moc dzialac na utworzonym juz obiekcie
        electricityMeter = Mockito.spy(electricityMeter);
        electricityMeter.setTariffon(true);
        electricityMeter.setElectricityTariffStartHour(12);
        electricityMeter.setElectricityTariffEndtHour(14);
    }

    //beda ogolnie 2 testy, jeden na taryfie i jeden bez taryfy
    //taryfa bedzie ustawiana na obiekcie stworzonym tu w klasie testujacej
    @Test
    public void givenOnTariffWhenKwhAdditionThenCounterTariffIsIncreased(){
        //Given z taryfa -- tutaj bedzie zaślepianie Mockito
            Mockito.when(electricityMeter.isTariffNow()).thenReturn(true);
        //When
        electricityMeter.addKwh(100);
        //Then
        //oczekujemy 100, aktualny stan pokaze metoda, delta okresli dopuszczalny blad
        Assert.assertEquals(100, electricityMeter.getKwhTariff(), 0.01);
    }

    @Test
    public void givenNoOnTariffWhenKwhAdditionThenCounterIsIncreased(){
        //Given bez taryfy - tutaj bedzie zaslepianie Mockito

        //When
        electricityMeter.addKwh(100);
        //Then
        //oczekujemy 100, aktualny stan pokaze metoda, delta okresli dopuszczalny blad
        Assert.assertEquals(100, electricityMeter.getKwhTariff(), 0.01);
    }
}
