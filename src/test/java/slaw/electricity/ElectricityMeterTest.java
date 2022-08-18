package slaw.electricity;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ElectricityMeterTest {

//sprawdzamy czy doda wartosc, --przypadek testowy--
    @Test
    public void addKwh() {
//nowy licznik
        ElectricityMeter electricityMeter = new ElectricityMeter();
//dodanie
        electricityMeter.addKwh(1);
//sprawdzamy czy jest prawda
        Assert.assertTrue(electricityMeter.getKwh() == 1); // trzeba dodac gettera
    }
}