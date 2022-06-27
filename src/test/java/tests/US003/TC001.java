package tests.US003;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TradylinnPageIbrahim;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC001 {
    TradylinnPageIbrahim trd=new TradylinnPageIbrahim();

    //US003_TC001: Siparişler sepette görünmeli

    @Test
    public void test01()  {

        //1_https://tradylinn.com  adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));
        //2_ "giriş yap" sekmesine tıkla
        trd.loginButton.click();
        //3_ Email kutusuna geçerli email gir
        trd.username.sendKeys(ConfigReader.getProperty("correctEmail"));
        //4_ password kutusuna geçerli paralo gir
        trd.password.sendKeys(ConfigReader.getProperty("correctPassword"));
        //5_ "giriş yap" butonuna tıkla
        trd.loginButton2.click();
        ReusableMethods.waitFor(15); //hesabım butonu gorunmesi zaman aldıgı icin bekleme suresi yerleştirdik.
        //6_"Hesabım" sekmesine tıkla
        trd.hesabimButton.click();
        //7_"Siparişler" butonuna tıkla
        trd.siparislerButton.click();
        //8_"Ürünlere göz at" butonuna tıkla
        JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();",trd.urunlereGozAtButton);
        //9_Ürün 1 icin sepete ekle ikonuna tıkla
        js.executeScript("arguments[0].click();",trd.urun1SepeteEkleButton);
        //10_Ürün 2 icin sepete ekle ikonuna tıkla
        js.executeScript("arguments[0].click();",trd.urun2SepeteEkleButton);
        //11_Ürün 3 icin sepete ekle ikonuna tıkla
        js.executeScript("arguments[0].click();",trd.urun3SepeteEkleButton);
        //12_Ürün 4 icin sepete ekle ikonuna tıkla
        js.executeScript("arguments[0].click();",trd.urun4SepeteEkleButton);
        //13_Ürün 5 icin sepete ekle ikonuna tıkla
        js.executeScript("arguments[0].click();",trd.urun5SepeteEkleButton);
        ReusableMethods.waitFor(10);  //urunlerin sepete eklenmesi zaman aldıgı icin bekleme suresi yerlestirdik
        //14_"Sepetim" butonuna tıkla
        trd.sepetimButton.click();

        //15_Siparişlerimin sepette oldugunu test et
        //herbir urunun kucuk resımlerının uzerınde beliren
        // (x) simgesi erişilebilir ise urunler sepete eklenmis demektir.
        //urunlerin sepete eklenmesi zaman aldıgı son remove button gorunene kadar  bekleme suresi yerlestirdik
        ReusableMethods.waitForVisibility(trd.removeButton5,120);
        Assert.assertTrue(trd.removeButton1.isEnabled());
        Assert.assertTrue(trd.removeButton2.isEnabled());
        Assert.assertTrue(trd.removeButton3.isEnabled());
        Assert.assertTrue(trd.removeButton4.isEnabled());
        Assert.assertTrue(trd.removeButton5.isEnabled());

        //sonraki testlerde hata almamak için sepeti temizliyoruz.
        trd.sepetiGoruntuleButton.click();
        js.executeScript("arguments[0].click();",trd.temizleButton);
        Driver.closeDriver();


















    }
}
