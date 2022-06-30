package tests.US004;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TradylinnPageIbrahim;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC002 {
    TradylinnPageIbrahim trd=new TradylinnPageIbrahim();


    //US004_TC002: Clear cart ile rakamlar silinebilmeli , Stok fazlası urun eklenememeli

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
        ReusableMethods.waitFor(10);  //urunlerin sepete eklenmesi zaman aldıgı icin bekleme suresi yerlestirdik
        //14_"Sepetim" butonuna tıkla
        trd.sepetimButton.click();

        //urunlerin sepete eklenmesi zaman aldıgından son remove button gorunene kadar  bekleme suresi yerlestirdik
        ReusableMethods.waitForVisibility(trd.removeButton5, 120);

        //15_"Sepeti Görüntüle" butonuna tıkla
        trd.sepetiGoruntuleButton.click();
        //16_"Temizle" butonuna tıkla
        js.executeScript("arguments[0].click();", trd.temizleButton);
        //17_Sepetin şu anda boş olduğunu test et
        //Sepetiniz şu anda boş. yazısı görünürse sepet temizlenmiş demektir.
        //ilgili yazı görünene kadar beklemesi için method kullandık.
        ReusableMethods.waitForVisibility(trd.sepetinizSuAndaBosYazisi, 120);
        Assert.assertTrue(trd.sepetinizSuAndaBosYazisi.isDisplayed());
        //18_Stok fazlası testi icin belirlenen ürün sayfasına git
        Driver.getDriver().get("https://tradylinn.com/urun/bambu-kati-sabunluk-dis-kose-oval/");
        //19_Miktar hanesine stokdan 1 fazlasını yaz
        //Stok sayısının yazılı oldugu cümledeki stok sayısını int olarak alabilmek için cümlenin başından
        //ilk boşluğa kadar kısmı substring ve indexOf kullanarak elde ettim.
        String stokSayisiString=trd.stokSayisiYazisi.getText();
        int stokSayisi= Integer.parseInt((stokSayisiString.substring(0, stokSayisiString.indexOf(" "))));
        int stokFazlasi=stokSayisi+1;
        String stokFazlasiYaziIle= String.valueOf(stokFazlasi); //Stringe çevirdim.
        trd.miktarHanesi2.sendKeys(Keys.DELETE+stokFazlasiYaziIle);
        //20_"Sepete ekle" butonuna tıkla
        trd.sepeteEkleStokFazlasi.click();
        //21_"Sepetim" butonuna tıkla
        trd.sepetimButton.click();
        //22_Stok fazlası ürünün sepete eklenmediğini test et
        //Stok fazlası ürünün eklenemediğinin delili olan "Sepetinizde Ürün Bulunmuyor." yazısı görünmeli
        ReusableMethods.waitForVisibility(trd.sepetinizdeUrunBulunmuyorYazisi,120);
        Assert.assertTrue(trd.sepetinizdeUrunBulunmuyorYazisi.isDisplayed());
        Driver.closeDriver();







    }
}