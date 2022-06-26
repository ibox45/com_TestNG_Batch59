package tests.US003;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TradylinnPageIbrahim;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;


public class TC002 {

    TradylinnPageIbrahim trd = new TradylinnPageIbrahim();

    //US003_TC002: Vendor olarak sipariş verilebilmeli

    @Test
    public void test01() {

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
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", trd.urunlereGozAtButton);
        //9_Ürün 1 icin sepete ekle ikonuna tıkla
        js.executeScript("arguments[0].click();", trd.urun1SepeteEkleButton);
        //10_Ürün 2 icin sepete ekle ikonuna tıkla
        js.executeScript("arguments[0].click();", trd.urun2SepeteEkleButton);
        //11_Ürün 3 icin sepete ekle ikonuna tıkla
        js.executeScript("arguments[0].click();", trd.urun3SepeteEkleButton);
        //12_Ürün 4 icin sepete ekle ikonuna tıkla
        js.executeScript("arguments[0].click();", trd.urun4SepeteEkleButton);
        //13_Ürün 5 icin sepete ekle ikonuna tıkla
        js.executeScript("arguments[0].click();", trd.urun5SepeteEkleButton);
        //14_"Sepetim" butonuna tıkla
        trd.sepetimButton.click();
        ReusableMethods.waitForVisibility(trd.removeButton5,120);  //urunlerin sepete eklenmesi zaman aldıgı
        // son ürün eklenene kadar bekleme suresi yerlestirdik
        //15_"Ödeme" butonuna tıkla
        trd.odemeButton.click();

        Faker faker=new Faker();  //Adres ve fatura bilgilerini girmek icin bir faker olusturduk.
        //16_Ad kutusuna Adını gir
        trd.adKutusu.sendKeys(faker.name().firstName());
        Actions actions=new Actions(Driver.getDriver()); //diğer bilgileri locate almadan yazabilmek icin actions olusturduk
        actions.sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())   //17_Soyad kutusuna soyadını gir
                .sendKeys(Keys.TAB)
                .sendKeys(faker.company().name())   //18_Firma adi kutusuna firma adı gir
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().streetAddress())  //19_Sokak adresi kutusuna bina numarası ve sokak adi gir
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().buildingNumber())  //20_Sokak adresi(2) kutusuna Apartman adi vb. gir
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().zipCode())   //21_Posta kodu kutusuna posta kodu gir
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().cityName())  //22_ilçe/Semt kutusuna İlçe gir
                .sendKeys(Keys.TAB)
                .sendKeys("Kocaeli")  //23_Şehir kutusuna şehir gir
                .sendKeys(Keys.ENTER)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().cellPhone())  //24_Telefon kutusuna telefon numarası gir
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress())  //25_E-posta kutusuna e-posta adresi gir
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().fullAddress()).perform();  //26_Teslimat adresi kutusuna adres gir






        //27_"Siparişi Onayla" butonuna tıkla
        js.executeScript("arguments[0].click();", trd.siparisiOnaylaButton);
        //28_Siparişin onaylandığını test et
        //"Teşekkür ederiz. Siparişiniz alınmıştır" yazisi ekranda görünüyorsa
        //siparis onaylanmıs demektir.
        //sipariş onayı mesajının gorunebılmesı icin  bir bekleme suresi ekledik.
        ReusableMethods.waitForVisibility(trd.siparisinizAlinmistirYazisi,120);

        Assert.assertTrue(trd.siparisinizAlinmistirYazisi.isDisplayed());
        Driver.closeDriver();











    }

}
