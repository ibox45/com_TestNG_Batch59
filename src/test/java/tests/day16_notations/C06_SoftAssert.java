package tests.day16_notations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class C06_SoftAssert extends TestBase {

    @Test(groups = "grup2")
    public void test01() {

        /*
        Softassertion baslangıc ve bitis satırları arasındakı tum assertion'ları yapıp bitiş satırına geldıgnde
        bize buldugu tum hataları rapor eder.
         */
        //softassertin baslangıcı obje olusturmaktır.
        SoftAssert softAssert=new SoftAssert();

        //1- amazon sayfasına gidin
        driver.get("https://www.amazon.com");
        //2-title'in Amazon icerdigni test edin
        String expectedTitle="Amazon";
        String actualTitle=driver.getTitle();
        softAssert.assertTrue(actualTitle.contains(expectedTitle),"title amazon icermiyor");
        //3-aramakutusunun erişilebilir oldugunu test edin
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        softAssert.assertTrue(aramaKutusu.isEnabled(),"arama kutusuna erisilemiyor");
        //4-arama kutusuna nutella yazıp aratın
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        //5-arama yapıldgını test edın
        WebElement sonucYazisiElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        softAssert.assertTrue(sonucYazisiElementi.isDisplayed(),"arama yapılamadı");
        //6-arama sonucun Nutella icerdgni test edin
        softAssert.assertTrue(sonucYazisiElementi.getText().contains("Nutella"),"sonuc yazisi Kutella icermiyor");


        //softassert'e bitiş satırını soylemek icin assertAll() kullanılır
        //bu satır yazılmassa assertion gorevi yapılmamıs olur.
        softAssert.assertAll();
        /*
        Softassert'un hata bulsa bile calısmaya devam etme ozellıgı
        assertAll()'a kadardır.
        Eğer assertAll()'da failed rapor edılırse calısma durur
        ve clasın kalan kısmı calıstırılmaz.
        (Yani assertAll hardAsserdeki herbir assert gibidir,hatayı yakalarsa calısma durur.
         */

        System.out.println("assertionlardan fail olan olursa burasi calismaz");




    }
}
