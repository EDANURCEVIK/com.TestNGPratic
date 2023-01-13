package tets.amazonTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02_AmazonGecis {

    @Test
    public void test01(){
        //amazon ansayfaya git
        AmazonPage amazonPage=new AmazonPage();
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        String amazonHandleDegeri=Driver.getDriver().getWindowHandle();
        //sayfanin en altina in
        Actions actions= new Actions(Driver.getDriver());
        actions.sendKeys(Keys.END).perform();
        //book depository e tikla
        WebElement bookDepository=Driver.getDriver().findElement(By.xpath("//a[text()='Book Depository']"));
        bookDepository.click();
        ReusableMethods.bekle(3);

        //acilan sayfaya gectigini test et
        String expectedUrl="https://www.bookdepository.com/";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);

        //amazon anasayfaya geri don
        Driver.getDriver().navigate().back();
        ReusableMethods.bekle(3);
        //amazon anasayfaya gectigini test et
        String expectedAmazonUrl="https://www.amazon.com/";
        String actualAmazonUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedAmazonUrl,actualAmazonUrl);
        //sayfayi kapat
        Driver.closeDriver();
    }
}
