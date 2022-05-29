package tests.day18_pom;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_ConfigReaderKullanimi {

    @Test
    public void test01() {
        FacebookPage facebookPage=new FacebookPage();

        //facebook anasayfasına gidin
        Driver.getDriver().get(ConfigReader.getProperty("facebookUrl"));
        //kullanıcı mail kutusuna rastgele bir isim yazdırın (fbWrongUsername)
        facebookPage.mailKutusu.sendKeys(ConfigReader.getProperty("fbWrongUsername"));


        //kullanıcı sifre kutusuna ratgele bir password yazdırın (fbWrongPassword)
        facebookPage.sifreKutusu.sendKeys(ConfigReader.getProperty("fbWrongPassword"));

        //login butonuna basin
        facebookPage.loginTusu.click();

        //giris yapılamadgnı test edin
        Assert.assertTrue(facebookPage.girilemediYaziElementi.isDisplayed());
        Driver.closeDriver();
    }
}
