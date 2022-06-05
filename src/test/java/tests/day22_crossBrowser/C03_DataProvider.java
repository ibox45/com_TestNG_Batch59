package tests.day22_crossBrowser;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_DataProvider {



    @Test
    public void test01(){
        AmazonPage amazonPage=new AmazonPage();
        //amazon anasayfaya gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        //nutella icin arama yapalım
        amazonPage.aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        //sonuclarin nutella icerdgni test edelim
        String expectedKelime="Nutella";
        String actualSonucYazisi=amazonPage.aramaSonucElementi.getText();

        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));

        Driver.closeDriver();

    }

    @DataProvider
    public static Object[][] AranacakKelimeler() {
        Object [][] arananKelimeArrayi={{"Nutella"},{"Java"},{"cigdem"},{"Netherlands"}};
        return arananKelimeArrayi;
    }

    @Test (dataProvider = "AranacakKelimeler")
    //arayacagmız kelımeleri bir liste gibi tutup
    // bana yollayacak bir veri saglayıcısı olusturacagız
    public void dataProviderTesti(String arananKelime) {

        AmazonPage amazonPage=new AmazonPage();
        //amazon anasayfaya gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        //Nutella , Java , cigdem ve Netherlands icin arama yapalim
        amazonPage.aramaKutusu.sendKeys(arananKelime+Keys.ENTER);

        //sonuclarin aradgmız kelime icerdgni test edelim
        String expectedKelime=arananKelime;
        String actualSonucYazisi=amazonPage.aramaSonucElementi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));


        //sayfayı kapatalım
        Driver.closeDriver();
    }
}
