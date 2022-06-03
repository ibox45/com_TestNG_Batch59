package tests.day16_notations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.time.Duration;

public class C04_DependsOnMethods  {

    /*
    DependsOnMethods test methodlarının calısma sıralamasına karısmaz
    sadece baglı olan test baglandıgı testın sonucuna bakar
    baglandıgı test PASSED olmassa, baglanan test hic calısmaz(ignore)
     */

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();

    }

    @Test
    public void test01() {
        //amazon sayfasına gidelim
        driver.get("https://amazon.com");
    }

    @Test (dependsOnMethods = "test01")
    public void test02() {
        //nutella aratalım
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

    }

    @Test(dependsOnMethods = "test02")
    public void test03() {

        //sonuc yazisinin Nutella icerdigini test edelim
        WebElement sonucYazisiElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        Assert.assertTrue(sonucYazisiElementi.getText().contains("Nutella"));
    }

    @Test(groups = {"grup1","grup2"})
    public void test04() {
        System.out.println("bak bu calisti");
    }
}
