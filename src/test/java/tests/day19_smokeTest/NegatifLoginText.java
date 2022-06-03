package tests.day19_smokeTest;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class NegatifLoginText {



    @Test
    public void yanlisSifre()  {
        BrcPage brcPage=new BrcPage();
        // Bir test method olustur positiveLoginTest()
        //       https://www.bluerentalcars.com/ adresine git

        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        //      login butonuna bas

        brcPage.ilkLoginButonu.click();

        //test data user email: customer@bluerentalcars.com ,
        brcPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcValidEmail"));
        //test data password : 12345
        brcPage.passwordTextBox.sendKeys(ConfigReader.getProperty("brcWrongPassword"));
        //      login butonuna bas
        brcPage.ikinciLoginButonu.click();
        //Degerleri girildiginde sayfaya basarili sekilde girilemedigini test et
        Assert.assertTrue(brcPage.ikinciLoginButonu.isDisplayed());
        Driver.closeDriver();



        //bu classda 2 test methodu daha olusturun
        //biri yanlıs kullanıcı
        //digeri de yanlıs sifre ve kullanıcı adı
        

    }

    @Test
    public void yanlisEmail()  {
        BrcPage brcPage=new BrcPage();
        // Bir test method olustur positiveLoginTest()
        //       https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        //      login butonuna bas

        brcPage.ilkLoginButonu.click();

        //test data user email: customer@bluerentalcars.com ,
        brcPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcWrongEmail"));
        //test data password : 12345
        brcPage.passwordTextBox.sendKeys(ConfigReader.getProperty("brcValidPassword"));
        //      login butonuna bas
        brcPage.ikinciLoginButonu.click();
        //Degerleri girildiginde sayfaya basarili sekilde girilemedigini test et
        Assert.assertTrue(brcPage.ikinciLoginButonu.isDisplayed());
        Driver.closeDriver();


    }


    @Test
    public void yanlisSifreVeEmail()  {
        BrcPage brcPage=new BrcPage();
        // Bir test method olustur positiveLoginTest()
        //       https://www.bluerentalcars.com/ adresine git

        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        //      login butonuna bas

        brcPage.ilkLoginButonu.click();

        //test data user email: customer@bluerentalcars.com ,
        brcPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcWrongEmail"));
        //test data password : 12345
        brcPage.passwordTextBox.sendKeys(ConfigReader.getProperty("brcWrongPassword"));
        //      login butonuna bas
        brcPage.ikinciLoginButonu.click();
        //Degerleri girildiginde sayfaya basarili sekilde girilemedigini test et
        Assert.assertTrue(brcPage.ikinciLoginButonu.isDisplayed());
        Driver.closeDriver();


    }

}
