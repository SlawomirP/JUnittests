package slaw;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import slaw.electricity.ElectricityMeterTest;
import slaw.electricity.TwoElectrocityMetersTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    ElectricityMeterTest.class,
        TwoElectrocityMetersTest.class
})

public class ElectricityMeterSuit {
}
