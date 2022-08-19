package slaw.electricity;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class ThreeElectrocityMetersTest {

    private static ElectricityMeter electricityMeter;

    @BeforeClass
    public static void init() {
        electricityMeter = new ElectricityMeter();
    }

    @Before
    public void ustawWarunki() {
        electricityMeter.reset();
    }

    @AfterClass
    public static void wyczyszczenieInit() {

    }

    @After
    public void likwidujUstawWarunki() {
    }

    public void addKwh() {
        electricityMeter.addKwh(1);
        electricityMeter.addKwh(2);
        Assert.assertTrue(electricityMeter.getKwh() == 3);
    }

    @Test(expected = ArithmeticException.class)
    public void getHowMoreExpensiveNormalIs() {
        electricityMeter.setCentsForKwh(90);
        electricityMeter.getHowMoreExpensiveNormalIs();

    }

    @Ignore("komunikat ktory pokaze sie jako komentarz przy tescie")
    @Test
    public void addKwh2() {
        electricityMeter.addKwh(1);
        Assert.assertTrue(electricityMeter.getKwh() == 1);

    }

    @Test
    public void givenNewMeterWhenFirstAddictionThenProperCounter() {
        //Given

        //When
        electricityMeter.addKwh(1);
        //Then
        Assert.assertTrue(electricityMeter.getKwh() == 1);
    }
}