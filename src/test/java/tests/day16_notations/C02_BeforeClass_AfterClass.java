package tests.day16_notations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_BeforeClass_AfterClass extends TestBase {

    //JUnit'te @BeforeClass ve @AfterClass notasyonuna sahip methodlar static olmak Zorundaydi.
    //TestNG bu zorunlulukdan kurtarıyor.

    /*
    TestNg bize daha fazla before ve after notasyonlari sunar
    diger before/after notasyonları tanımlayacagımız
    grup, test veya suit'ten once ve sonra calısırlar
    ileride xml dosyaları ile birlikte bunu gorecegiz.
     */

    @BeforeClass
    public void beforeClassMethod() {
        System.out.println("Before Class");

    }

    @AfterClass
    public void afterClassMethod() {
        System.out.println("After Class");

    }

    @Test
    public void amazonTesti() {

        driver.get("https://www.amazon.com");
        System.out.println(driver.getCurrentUrl());

    }

    @Test
    public void test02() {

        driver.get("https://www.bestbuy.com");
        System.out.println(driver.getCurrentUrl());
    }

    @Test
    public void techproedTesti() {
        driver.get("https://www.techproeducation.com");
        System.out.println(driver.getCurrentUrl());
    }
}
