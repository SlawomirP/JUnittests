package slaw.electricity;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;


import java.util.Arrays;
import java.util.Collection;

//JEST TO NOWA KLASA DO ZAPRAEZENTOWANIA TESTOW SPARAMATRYZOWANYCH


//Adnotacja z JUnita
@RunWith(Parameterized.class)
public class EdgeTariffElectricityMeterTest {

    static ElectricityMeter electricityMeter;

    static TariffProvider tp;

    //podajemy pola dla kazdego przypadku
    private Integer kwhUsedInCase; //kwh w przypadku
    private boolean isTariffInCase; // taryfa przypadku
    private float sumKwhInCase; //suma kwh w przypadku
    private float sumKwhTariffInCase; // suma kwh w taryfie

    //we wprowadzanieu parametrow posluzymy sie konstruktorem


    public EdgeTariffElectricityMeterTest(Integer kwhUsedInCase, boolean isTariffInCase, float sumKwhInCase, float sumKwhTariffInCase) {
        this.kwhUsedInCase = kwhUsedInCase;
        this.isTariffInCase = isTariffInCase;
        this.sumKwhInCase = sumKwhInCase;
        this.sumKwhTariffInCase = sumKwhTariffInCase;
    }

    @BeforeClass // przestawiamy na static - stworzy raz i ciagle uzywa
    public static void setUp() {
        tp = Mockito.mock(TariffProvider.class);
        electricityMeter = new ElectricityMeter(tp);
        electricityMeter.setTariffon(true);
    }

    //w ten test podmieniamy pola
    @Test
    public void givenOnTariffWhenKwhAdditionTheSpecificCounterTariffIsIncreased() {
        //Given
        Mockito.when(tp.isTariffNow()).thenReturn(isTariffInCase);
        //When
        electricityMeter.addKwh(kwhUsedInCase);
        //Then
        if (isTariffInCase) {
            Assert.assertEquals(sumKwhTariffInCase, electricityMeter.getKwhTariff(), 0.01);
        } else {
            Assert.assertEquals(sumKwhInCase, electricityMeter.getKwh(), 0.01);

        }
    }


    //TUTAJ WRZUCAMY DANE PROSTO Z EXCELA ODPOWIEDNIO JE OBRABIAJAC
    //ZAZNACZAM SLOWO FALSZ I CTRL + R ZAMIENIAM WSZYTKO NA FALSE
    //nastepnie klikam przed 100 i wcisnietym scrolem (ew ctr+ctrl i trzymac
    //  potem tylko strz w dol) powielam kursor
    //jadac do samego dolu, nastepnie otworzylem klamre, ctrl + -> i przechodzac
    //dalej robie przecinki i na koncu zamykam klamra, potem klamerka na poczatku
    //i na koncu i jest gotowa tablica tablic

    //metoda statyczne ktora uzupelni dane do konstruktora
    @Parameterized.Parameters
    public static Collection daneWejsciowe() {
        return Arrays.asList(new Object[][]{
                {
                        100, false, 100, 0
                },
                {
                        100, false, 200, 0
                },
                {
                        100, false, 300, 0
                },
                {
                        100, false, 400, 0
                },
                {
                        100, false, 500, 0
                },
                {
                        100, false, 600, 0
                },
                {
                        100, false, 700, 0
                },
                {
                        100, false, 800, 0
                },
                {
                        100, false, 900, 0
                },
                {
                        100, false, 1000, 0
                },
                {
                        100, false, 1100, 0
                },
                {
                        100, false, 1200, 0
                },
                {
                        150, false, 1350, 0
                },
                {
                        200, false, 1550, 0
                },
                {
                        200, false, 1750, 0
                },
                {
                        400, false, 2150, 0
                },
                {
                        150, false, 2300, 0
                },
                {
                        100, false, 2400, 0
                },
                {
                        100, false, 2500, 0
                },
                {
                        100, false, 2600, 0
                },
                {
                        100, false, 2700, 0
                },
                {
                        100, false, 2800, 0
                },
                {
                        100, false, 2900, 0
                },
                {
                        100, false, 3000, 0
                },
                {
                        100, false, 3100, 0
                },
                {
                        100, false, 3200, 0
                },
                {
                        100, true, 3200, 100
                },
                {
                        100, true, 3200, 200
                },
                {
                        1800, true, 3200, 2000
                },
                {
                        2000, true, 3200, 4000
                },
                {
                        100, false, 3300, 4000
                },
                {
                        100, false, 3400, 4000
                },
                {
                        100, false, 3500, 4000
                },
                {
                        300, false, 3800, 4000
                },
                {
                        300, false, 4100, 4000
                },
                {
                        300, false, 4400, 4000
                },
                {
                        300, false, 4700, 4000
                },
                {
                        3000, false, 7700, 4000
                },
                {
                        3200, false, 10900, 4000
                },
                {
                        3000, false, 13900, 4000
                },
                {
                        450, false, 14350, 4000
                },
                {
                        550, false, 14900, 4000
                },
                {
                        300, false, 15200, 4000
                },
                {
                        250, false, 15450, 4000
                },
                {
                        200, false, 15650, 4000
                },
                {
                        200, false, 15850, 4000
                },
                {
                        300, false, 16150, 4000
                },
                {
                        100, false, 16250, 4000
                },
                {
                        100, false, 16350, 4000
                }
        });
    }
}




