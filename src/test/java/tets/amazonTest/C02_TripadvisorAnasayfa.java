package tets.amazonTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TripAdvisorPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02_TripadvisorAnasayfa {
    @Test
    public void test01(){
        //TripAdvisor anasayfa'ya git
        Driver.getDriver().get(ConfigReader.getProperty("tripadvisorUrl"));
        //sayfada cookies'leri kabul et
        WebElement cookies=Driver.getDriver().findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        cookies.click();
        Actions actions=new Actions(Driver.getDriver());
        //arama butonuna tiklayip "floransa" arat
        TripAdvisorPage tripAdvisorPage=new TripAdvisorPage();

        actions.click(tripAdvisorPage.aramaButonu).sendKeys("floransa"+Keys.ENTER).perform();
        ReusableMethods.bekle(3);

        //cikan sonuclarin floransa icerdigini test et
        System.out.println(tripAdvisorPage.sonucYaziElementi);
        String expectedKelime="floransa";
        String actualSonucYazisi= tripAdvisorPage.sonucYaziElementi.getText();

        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));
        //floransa aramasindaki oteller sekmesine git
        WebElement oteller=Driver.getDriver().findElement(By.xpath("//a[@data-tab-name='Oteller']"));
        actions.click(oteller).perform();
        ReusableMethods.bekle(3);
        //sayfayi kapat
        Driver.closeDriver();
    }
}
