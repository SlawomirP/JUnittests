package slaw.electricity;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class TwoElectrocityMetersTest { // zestaw testow

//sprawdzamy czy doda wartosc, --przypadek testowy--
    @Test
    public void addKwh() {
//nowy licznik -given
        ElectricityMeter electricityMeter = new ElectricityMeter();
        ElectricityMeter electricityMeter1 = new ElectricityMeter();
//dodanie -when
        electricityMeter.addKwh(1);
//sprawdzamy czy jest prawda -than
        Assert.assertTrue(electricityMeter.getKwh() == 1);// trzeba dodac gettera

        //Assert.assertTrue("powinno dac 1", electricityMeter.getKwh() == 1);
    }


    //testowanie wyjatku, pamietać o dodaniu expected
    @Test (expected = ArithmeticException.class)
    public void getHowMoreExpensiveNormalIs() {
        ElectricityMeter electricityMeter = new ElectricityMeter();
        ElectricityMeter electricityMeter1 = new ElectricityMeter();
        electricityMeter.setCentsForKwh(90);
        electricityMeter.getHowMoreExpensiveNormalIs();

    }
    //ignorowanie testu
    @Ignore ("komunikat ktory pokaze sie jako komentarz przy tescie")
    @Test
    public void addKwh2() {
        ElectricityMeter electricityMeter = new ElectricityMeter();
        ElectricityMeter electricityMeter1 = new ElectricityMeter();
        electricityMeter.addKwh(1);
        Assert.assertTrue(electricityMeter.getKwh() == 1);// trzeba dodac gettera

    }

    //GWT GIVEN WHEN THEN
    @Test
    public void givenNewMeterWhenFirstAddictionThenProperCounter(){
        //Given
        ElectricityMeter electricityMeter = new ElectricityMeter();
        ElectricityMeter electricityMeter1 = new ElectricityMeter();
        //When
        electricityMeter.addKwh(1);
        //Then
        Assert.assertTrue(electricityMeter.getKwh() == 1);
    }


}