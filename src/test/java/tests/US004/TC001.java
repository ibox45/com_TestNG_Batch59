package tests.US004;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TradylinnPageIbrahim;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;



public class TC001 {

    TradylinnPageIbrahim trd=new TradylinnPageIbrahim();


    //US004_TC001: Ürünlerin sepette görünmesi, (+) ve (-) butonu ile ürün sayısı arttırılması ve azaltılması,
                // Kupon seceneği, Alışverise devam et butonu, Kargo bilgileri,
                // Toplam bilgisi,Ödeme sayfasına yönlendirilme

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
        //urunlerin sepete eklenmesi zaman aldıgından son remove button gorunene kadar  bekleme suresi yerlestirdik
        ReusableMethods.waitForVisibility(trd.removeButton5,120);

        //15_"Sepeti Görüntüle" butonuna tıkla
        trd.sepetiGoruntuleButton.click();
        //16_Ürünlerin sepette görüldügünü test et
        //5 ürün eklediğim için 5 satırdan oluşan içerisinde fiyat miktar ve ara toplam degerleri olan
        // sepet ögeleri tablosu görmeliyim

        Assert.assertTrue(trd.sepetOgesiSatir1.isDisplayed());
        Assert.assertTrue(trd.sepetOgesiSatir2.isDisplayed());
        Assert.assertTrue(trd.sepetOgesiSatir3.isDisplayed());
        Assert.assertTrue(trd.sepetOgesiSatir4.isDisplayed());
        Assert.assertTrue(trd.sepetOgesiSatir5.isDisplayed());

        //17_"Ürün" yazisinin görüldüğünü test et
        Assert.assertTrue(trd.urunYazisi.isDisplayed());
        //18_"Fiyat" yazisinin görüldüğünü test  et
        Assert.assertTrue(trd.fiyatYazisi.isDisplayed());
        //19_"Miktar" yazisinin görüldüğünü test et
        Assert.assertTrue(trd.miktarYazisi.isDisplayed());
        //20_"Ara Toplam" yazisinin görüldüğünü test et
        Assert.assertTrue(trd.araToplamYazisi.isDisplayed());
        //21_"Kupon kullan" butonunun oldugunu test et
        Assert.assertTrue(trd.kuponKullanButton.isDisplayed());
        //22_"Alışverişe devam et" butonunun oldugunu test et
        Assert.assertTrue(trd.alisVeriseDevamEtButton.isDisplayed());
        //23_Kargo bilgilerinin  görüldüğünü test et
        Assert.assertTrue(trd.kargoBilgileriYazisi.isDisplayed());
        //24_Sağda toplam bilgisinin oldugunu test et
        Assert.assertTrue(trd.toplamBilgisi.isDisplayed());
        //25_"+(artı)" butonuna  tıkla
        //artı butonuna basıp sayfayı yeniledigimde fiyat toplamı ve miktar hanesi guncellenmesi gerekir.
        //Bunu kontrol etmek icin butona tıklamadan onceki fiyat bilgisini ve miktar hanesini kaydediyorum.
        String toplamFiyatYazisi1= trd.toplamFiyatYazisi.getText();
        int  miktarHanesiSayisi1= Integer.parseInt(trd.miktarHanesi.getAttribute("value"));
        //Sepetteki 2. ürün için + butonuna tıklamayı tercih ettim.
        trd.artiButton.click();
        //26_"Sepeti yenile" butonuna tıkla
        js.executeScript("arguments[0].click();",trd.sepetiYenileButton);
        ReusableMethods.waitFor(20);
        //27_Fiyatın guncellendigini test et
        String toplamFiyatYazisi2=trd.toplamFiyatYazisi.getText();
        //önceki ve sonraki fiyat aynı değilse fiyat guncellenmiştir demektir.
        Assert.assertNotEquals(toplamFiyatYazisi2, toplamFiyatYazisi1);
        //28_Miktarın  arttıgını test et
        int  miktarHanesiSayisi2= Integer.parseInt(trd.miktarHanesi.getAttribute("value"));
        // sonraki miktar hanesi sayisi öncekinden 1 fazla ise miktar artmış demektir.
        Assert.assertTrue(miktarHanesiSayisi2==miktarHanesiSayisi1+1);
        //29_"-(eksi)" butonuna tıkla
        trd.eksiButton.click();
        //30_"Sepeti yenile" butonuna tıkla
        js.executeScript("arguments[0].click();",trd.sepetiYenileButton);
        ReusableMethods.waitFor(20);
        //31_"Miktarın  eksildigini test et
        int  miktarHanesiSayisi3= Integer.parseInt(trd.miktarHanesi.getAttribute("value"));
        //miktarHanesiSayisi3 ,miktarHanesiSayisi2'den bir eksik ise miktar azalmış demektir.
        Assert.assertTrue(miktarHanesiSayisi3==miktarHanesiSayisi2-1);
        //32_"Ödeme sayfasına git" butonuna tıkla
        js.executeScript("arguments[0].click();",trd.odemeSayfasinaGitButton);
        //33_Ödeme sayfasına yönlendirildiğini test et
        //Ödeme sayfasına yönlendirildiğimizin delili olan "fatura detayları alanı" görünmeli
        Assert.assertTrue(trd.faturaDetaylariAlani.isDisplayed());
        Driver.closeDriver();













































    }
}
