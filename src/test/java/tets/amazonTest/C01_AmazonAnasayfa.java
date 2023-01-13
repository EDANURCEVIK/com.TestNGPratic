package tets.amazonTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_AmazonAnasayfa {

    @Test
    public void test01(){
        //amazon anasayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        // all menu ye tikla
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.allMenu.click();

        ReusableMethods.bekle(2);
        // all menu den electronics i sec
        WebElement electronics=Driver.getDriver().findElement(By.xpath("//a[@data-menu-id='5']"));
        electronics.click();
        ReusableMethods.bekle(2);
        // electronics'den camera photo yu sec
        WebElement cameraPhoto=Driver.getDriver().findElement(By.xpath("//a[text()='Camera & Photo']"));
        cameraPhoto.click();
        ReusableMethods.bekle(2);
        // camera photo dan digital cameras i sec
        WebElement digitalCameras=Driver.getDriver().findElement(By.xpath("//span[text()='Digital Cameras']"));
        digitalCameras.click();
        ReusableMethods.bekle(2);
        // sayfanin digital camera da oldugunu test et
        WebElement dropdownElementi=Driver.getDriver().findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select=new Select(dropdownElementi);
        select.selectByVisibleText("Digital Cameras");
        String actualOption=select.getFirstSelectedOption().getText();
        String expectedKelime="Digital Cameras";
        Assert.assertEquals(expectedKelime,actualOption);
        //sayfayi kapat
        Driver.closeDriver();

    }
}
