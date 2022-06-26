package tests.US022;


import org.openqa.selenium.JavascriptExecutor;


import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import org.testng.Assert;
import org.testng.annotations.Test;

import org.testng.asserts.SoftAssert;
import pages.TradylinnPageMustafa;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;


public class TC001 extends TestBaseRapor {

    TradylinnPageMustafa trd = new TradylinnPageMustafa();
    Actions actions = new Actions(Driver.getDriver());
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    Select select;
    String actual;
    SoftAssert softassert = new SoftAssert();


    @Test
    public void TC001() {
        extentTest = extentReports.createTest("US022_TC001 TC002", "Tumunu gor linki ile kategorinin ana sayfalarina bolumu gorunmeli");

        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));
        extentTest.info("Ana sayfaya gidildi");
        softassert.assertTrue(trd.tumunugorButton.isDisplayed()); //2_Tumunu gor linki is displayed
        extentTest.info("Tumunu gor linki gorunurlugu test edildi");

        /** action olarak page down yaparak tiklama **********
         actions.sendKeys(Keys.PAGE_DOWN)
         .sendKeys(Keys.PAGE_DOWN)
         .perform();//link gormesi icin page down uygulandi
         trd.tumunugorButton.click();
         */

        js.executeScript("arguments[0].click();", trd.tumunugorButton);
        //javaScript ile tiklama

        trd.kategoriAnaSayfaButton.click();//3_kategorinin ana sayfa goturne
        extentTest.info("kategorinin ana sayfa goturne yapildi");

        //******TC002******
        //2_ Indirimli ürünler tikla
        js.executeScript("arguments[0].click();", trd.tumunugorButton);
        trd.siralamaButton.click();
        extentTest.info("Tumunu gor linki tiklandi");
        //3_ Siralama button
        //4_ Select sırala secim
        select = new Select(trd.selectSiralama);
        //5_Varsayılan Sıralama -> Bu default seçenek olmali tikla
        actual = select.getFirstSelectedOption().getAccessibleName(); //Varsayılan Sıralama -> default seçenek
        softassert.assertEquals(actual, "Varsayılan Sıralama"); //Varsayılan Sıralama -> Bu default seçenek olmali kontrolu
        extentTest.info("Varsayılan Sıralama -> Bu default seçenek test edildi");

        //6_ En çok incelenene göre sırala tikla
        select.selectByVisibleText("En çok incelenene göre sırala");
        extentTest.info("En çok incelenene göre sırala tiklandi");

        //7_ En çok oy alana göre sırala tikla
        select.selectByVisibleText("En çok oy alana göre sırala");
        extentTest.info("En çok oy alana göre sırala tiklandi");

        //8_En yeniye göre sırala tikla
        select.selectByVisibleText("En yeniye göre sırala");
        extentTest.info("En yeniye göre sırala tiklandi");

        //9_Fiyata göre sırala: Düşükten yükseğe tikla
        select.selectByVisibleText("Fiyata göre sırala: Düşükten yükseğe");
        extentTest.info("Fiyata göre sırala: Düşükten yükseğe tiklandi");

        //10_Fiyata göre sırala: Yüksekten düşüğe tikla
        select.selectByVisibleText("Fiyata göre sırala: Yüksekten düşüğe");
        extentTest.info("Fiyata göre sırala: Yüksekten düşüğe tiklandi");


          Driver.closeDriver();
    }

    @Test
    public void TC003() {
        extentTest = extentReports.createTest("US022_TC003", "Fiyata göre sırala: Düşükten yükseğe seçildiğinde fiyatlar kucukten buyuge gore sıralanmalı testi");

        //1_https://tradylinn.com/  adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));
        extentTest.info("Ana sayfaya gidildi");
        //2_ Indirimli ürünler tikla
        js.executeScript("arguments[0].click();", trd.indirimliUurunlerLinki);
        trd.siralamaButton.click();
        extentTest.info("Indirimli ürünler tiklandi");
        //3_ Siralama button
        select = new Select(trd.selectSiralama);
        //4_Fiyata göre sırala: Düşükten yükseğe
        select.selectByVisibleText("Fiyata göre sırala: Düşükten yükseğe");
        extentTest.info("Fiyata göre sırala: Düşükten yükseğe tiklandi");

        int fiyat = 0;
        for (int i = 0; i < trd.urunFiyatIndirimli.size(); i++) {

            String str = trd.urunFiyatIndirimli.get(i).getText().replaceAll("[^a-zA-Z0-9]", "");////rakam ve nokta haric hepsini hiclik yaptik bunu string e atadik
            int indirimfiyat = Integer.parseInt(str);//string degeri int yaptik

            if (fiyat <= indirimfiyat) { //fiyat kucuk esitse indirimli urunler kucukten buyuge siralamasi dogru
                fiyat = indirimfiyat;
            } else {
                softassert.fail("urunler, Fiyata göre sırala: Düşükten yükseğe siralanmamis");
                //  Assert.fail("urunler, Fiyata göre sırala: Düşükten yükseğe siralanmamis");
                break;
            }
        }
        extentTest.info("Fiyata göre sırala: Düşükten yükseğe test edildi");
         Driver.closeDriver();

    }

    @Test
    public void TC004() {
        extentTest = extentReports.createTest("US022_TC004", "Fiyata göre sırala: Yüksekten düşüğe seçildiğinde fiyatlar büyükten kucuge gore sıralanmalı testi");

        //1_https://tradylinn.com/  adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));
        extentTest.info("Ana sayfaya gidildi");
        //2_ Indirimli ürünler tikla
        js.executeScript("arguments[0].click();", trd.indirimliUurunlerLinki);
        trd.siralamaButton.click();
        extentTest.info("Indirimli ürünler tiklandi");
        //3_ Siralama button
        select = new Select(trd.selectSiralama);
        //4_Fiyata göre sırala: Yüksekten düşüğe
        select.selectByVisibleText("Fiyata göre sırala: Yüksekten düşüğe");
        extentTest.info("Fiyata göre sırala: Yüksekten düşüğe tiklandi");


        double
                fiyat = Double.parseDouble(trd.urunFiyatIndirimli
                .get(0).getText().replaceAll("[^a-zA-Z0-9.]", "").toString());
        //string degeri double yaparak double ile karsilastirma yapilacak
        //0. indeksten itibaren kiyaslamaya basliyacagiz
        for (int i = 0; i < trd.urunFiyatIndirimli.size(); i++) {
            String str = trd.urunFiyatIndirimli.get(i).getText().replaceAll("[^a-zA-Z0-9.]", "");//rakam ve nokta haric hepsini hiclik yaptik bunu string e atadik

            double indrimliFiyat = Double.parseDouble(str);
            if (fiyat >= indrimliFiyat) { //fiyat buyuk esitse indirimli urunler buyukten kucuger siralamasi dogru
                fiyat = indrimliFiyat;
            } else {
                softassert.fail("urunler, Fiyata göre sırala: Yüksekten düşüğe siralanmamis");
                // Assert.fail("urunler, Fiyata göre sırala: Yüksekten düşüğe siralanmamis");
                break;
            }

        }

        extentTest.info("Fiyata göre sırala: Yüksekten düşüğe test edildi");
        Driver.closeDriver();

    }

}
