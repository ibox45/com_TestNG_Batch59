package tests.day16_notations;

import org.testng.annotations.Test;
import utilities.TestBase;

public class C01_BeforeMethod_AfterMethod extends TestBase {

    //@BeforeMethod ve QafterMethod notasyonlari
    //Junit'deki gibi @Before ve @After gibidir.
    //her test method'undan once ve sonra calısırlar.


    @Test
    public void amazonTesti() {

        driver.get("https://www.amazon.com");

    }

    @Test
    public void test02() {

        driver.get("https://www.bestbuy.com");
    }

    @Test
    public void techproedTesti() {
        driver.get("https://www.techproeducation.com");
    }


}
