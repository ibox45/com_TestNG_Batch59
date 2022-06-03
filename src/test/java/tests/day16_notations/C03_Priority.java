package tests.day16_notations;

import org.testng.annotations.Test;
import utilities.TestBase;

public class C03_Priority extends TestBase {

    /*
    TestNg test methodlarını isim sırasına gore calıstırır
    eger isim sıralamasının dısında bir sıralama ile calsımasını istersenız
    ozaman test methodlarına oncelık (Priority) tanımlayabılırsınız

    Priority kucukten buyuge gore calısır
    eger bir test methoduna priority degeri atanmamıssa
    default olarak Priority=0 kabul edilir.
     */


    @Test (priority = -5)
    public void amazonTesti() {

        driver.get("https://www.amazon.com");

    }

    @Test(priority = -2)
    public void test02() {

        driver.get("https://www.bestbuy.com");
    }

    @Test(groups="grup1")
    public void techproedTesti() {

        driver.get("https://www.techproeducation.com");
        System.out.println(driver.getCurrentUrl());
    }


}
