package slaw.electricity;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ElectricityMeterTest { // zestaw testow

//sprawdzamy czy doda wartosc, --przypadek testowy--
    @Test
    public void addKwh() {
//nowy licznik -given
        ElectricityMeter electricityMeter = new ElectricityMeter();
//dodanie -when
        electricityMeter.addKwh(1);
//sprawdzamy czy jest prawda -than
        Assert.assertTrue(electricityMeter.getKwh() == 1);// trzeba dodac gettera

        //Assert.assertTrue("powinno dac 1", electricityMeter.getKwh() == 1);
    }
}