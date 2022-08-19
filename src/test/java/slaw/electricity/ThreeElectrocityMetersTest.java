package slaw.electricity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class ThreeElectrocityMetersTest {

    static ElectricityMeter electricityMeter; // obiekt tworzony niżej

    @BeforeClass //adnotacja z JUnita -- zlożone, skomplikowane,
    // czasochłonne instrukcje zostanie to stworzone raz i
    // bedzie używane przez wszystko
    public static void init(){
        electricityMeter = new ElectricityMeter(); // static !!!
    }

    @Before //adnotacja z JUnita -- wykona sie przed kazdym testem
    //mozna tutaj np ustawic warunki poczatkowe, przyklad reset prametrow
    //tworzymy tutaj środowisko deterministyczne dla testów
    public void ustawWarunki(){
        electricityMeter.reset();
    }


    @Test
    public void addKwh() {
        ElectricityMeter electricityMeter = new ElectricityMeter();
        ElectricityMeter electricityMeter1 = new ElectricityMeter();
        electricityMeter.addKwh(1);
        Assert.assertTrue(electricityMeter.getKwh() == 1);
    }

    @Test(expected = ArithmeticException.class)
    public void getHowMoreExpensiveNormalIs() {
        ElectricityMeter electricityMeter = new ElectricityMeter();
        ElectricityMeter electricityMeter1 = new ElectricityMeter();
        electricityMeter.setCentsForKwh(90);
        electricityMeter.getHowMoreExpensiveNormalIs();

    }

    @Ignore("komunikat ktory pokaze sie jako komentarz przy tescie")
    @Test
    public void addKwh2() {
        ElectricityMeter electricityMeter = new ElectricityMeter();
        ElectricityMeter electricityMeter1 = new ElectricityMeter();
        electricityMeter.addKwh(1);
        Assert.assertTrue(electricityMeter.getKwh() == 1);

    }

    @Test
    public void givenNewMeterWhenFirstAddictionThenProperCounter() {
        //Given
        ElectricityMeter electricityMeter = new ElectricityMeter();
        ElectricityMeter electricityMeter1 = new ElectricityMeter();
        //When
        electricityMeter.addKwh(1);
        //Then
        Assert.assertTrue(electricityMeter.getKwh() == 1);
    }
}