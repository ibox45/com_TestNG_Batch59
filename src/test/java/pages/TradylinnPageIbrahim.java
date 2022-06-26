package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TradylinnPageIbrahim {
    public TradylinnPageIbrahim() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath="//a[@class='login inline-type']")
    public WebElement loginButton;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement password;

    @FindBy(xpath = "//button[@name='login']")
    public WebElement loginButton2;

    @FindBy (xpath = "//li[@id='menu-item-1074']")
    public WebElement hesabimButton;

    @FindBy(xpath = "//li[@class='woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation-link--orders']")
    public WebElement siparislerButton;

    @FindBy(xpath="(//a[@href='https://tradylinn.com/shop/'])[1]")
    public WebElement urunlereGozAtButton;

    @FindBy(xpath = "(//a[@class='btn-product-icon product_type_simple add_to_cart_button ajax_add_to_cart'])[1]")
    public WebElement urun1SepeteEkleButton;

    @FindBy(xpath = "(//a[@class='btn-product-icon product_type_simple add_to_cart_button ajax_add_to_cart'])[2]")
    public WebElement urun2SepeteEkleButton;

    @FindBy(xpath = "(//a[@class='btn-product-icon product_type_simple add_to_cart_button ajax_add_to_cart'])[3]")
    public WebElement urun3SepeteEkleButton;

    @FindBy(xpath = "(//a[@class='btn-product-icon product_type_simple add_to_cart_button ajax_add_to_cart'])[4]")
    public WebElement urun4SepeteEkleButton;

    @FindBy(xpath = "(//a[@class='btn-product-icon product_type_simple add_to_cart_button ajax_add_to_cart'])[5]")
    public WebElement urun5SepeteEkleButton;

    @FindBy(xpath = "//span[@class='cart-name']")
    public WebElement sepetimButton;

    @FindBy(xpath = "(//i[@class='fas fa-times'])[1]")
    public WebElement removeButton1;

    @FindBy(xpath = "(//i[@class='fas fa-times'])[2]")
    public WebElement removeButton2;

    @FindBy(xpath = "(//i[@class='fas fa-times'])[3]")
    public WebElement removeButton3;

    @FindBy(xpath = "(//i[@class='fas fa-times'])[4]")
    public WebElement removeButton4;

    @FindBy(xpath = "(//i[@class='fas fa-times'])[5]")
    public WebElement removeButton5;

    @FindBy(xpath = "//a[@class='button checkout wc-forward']")
    public WebElement odemeButton;

    @FindBy(xpath = "//input[@id='billing_first_name']")
    public WebElement adKutusu;

    @FindBy(xpath = "//button[@id='place_order']")
    public WebElement siparisiOnaylaButton;

    @FindBy(xpath="//p[@class='woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received order-success']")
    public WebElement siparisinizAlinmistirYazisi;

    @FindBy(xpath = "//input[@id='payment_method_cod']")
    public WebElement payAtTheDoorRadioButton;

    @FindBy(xpath = "//a[@class='button wc-forward']")
    public WebElement sepetiGoruntuleButton;

    @FindBy(xpath = "//button[@name='clear_cart']")
    public WebElement temizleButton;



















}
