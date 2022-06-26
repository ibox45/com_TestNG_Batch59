package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TradylinnPageMustafa {

    public TradylinnPageMustafa() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div[1]/div/div/div/section/div/div[2]/div/div/div/h2/a")
    public WebElement tumunugorButton;

    @FindBy(xpath = "//a[text()='İndirimli Ürünler']")
    public WebElement indirimliUurunlerLinki;

    @FindBy(xpath = " (//li/a['Ana Sayfa'])[3]")
    public WebElement kategoriAnaSayfaButton;

    @FindBy(xpath = "//select[@name='orderby']")
    public WebElement siralamaButton;
    @FindBy(xpath = "//select[@name='orderby']")
    public WebElement selectSiralama;
    @FindBy(xpath = "//span [@class='price']/ins")
    public List<WebElement> urunFiyatIndirimli;


}