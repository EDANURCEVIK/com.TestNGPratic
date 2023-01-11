package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonPage {
    // page sayfasinda kullanilacak locateler
    // ve varsa login islemi gibi basit method lar icin kullanilir

    public AmazonPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id="twotabsearchtextbox")
    public WebElement amazonAramaKutusu;

    @FindBy(xpath ="//div[@class='a-section a-spacing-small a-spacing-top-small']" )
    public WebElement aramaSonucuElementi;

    @FindBy(xpath = "//a[@id='nav-hamburger-menu']")
    public WebElement allMenu;



}
