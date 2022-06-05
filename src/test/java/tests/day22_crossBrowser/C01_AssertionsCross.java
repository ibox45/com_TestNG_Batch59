package tests.day22_crossBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseCross;

public class C01_AssertionsCross extends TestBaseCross {
    @Test
    public void test01() {

        //1- amazon sayfasına gidin
        driver.get("https://www.amazon.com");
        //2-title'in Amazon icerdigni test edin
        String expectedTitle="Amazon";
        String actualTitle=driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        //3-aramakutusunun erişilebilir oldugunu test edin
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        Assert.assertTrue(aramaKutusu.isEnabled());
        //4-arama kutusuna nutella yazıp aratın
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        //5-arama yapıldgını test edın
        WebElement sonucYazisiElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(sonucYazisiElementi.isDisplayed());
        //6-arama sonucun Nutella icerdgni test edin
        Assert.assertTrue(sonucYazisiElementi.getText().contains("Nutella"));



    }
}
