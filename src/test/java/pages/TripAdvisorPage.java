package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TripAdvisorPage {
    public TripAdvisorPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//form[@role='search'])[2]")
    public WebElement aramaButonu;

    @FindBy(xpath = "//span[@class='title-query']")
    public WebElement sonucYaziElementi;
}
