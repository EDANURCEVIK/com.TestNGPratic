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
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        AmazonPage amazonPage = new AmazonPage();
        amazonPage.allMenu.click();

        //WebElement allMenu=Driver.getDriver().findElement(By.xpath("//a[@id='nav-hamburger-menu']"));
        //allMenu.click();
        ReusableMethods.bekle(2);
        WebElement electronics=Driver.getDriver().findElement(By.xpath("//a[@data-menu-id='5']"));
        electronics.click();
        ReusableMethods.bekle(2);
        WebElement cameraPhoto=Driver.getDriver().findElement(By.xpath("//a[text()='Camera & Photo']"));
        cameraPhoto.click();
        ReusableMethods.bekle(2);
        WebElement digitalCameras=Driver.getDriver().findElement(By.xpath("//span[text()='Digital Cameras']"));
        digitalCameras.click();
        ReusableMethods.bekle(2);
        /*
        WebElement sonucYazi=Driver.getDriver().findElement(By.xpath("//options[@value='node=281052']"));
        String expectedKelime="Digital Cameras";
        String actualSonucYazi=sonucYazi.getText();
        System.out.println(actualSonucYazi);
        Assert.assertTrue(actualSonucYazi.contains(expectedKelime));

         */
        WebElement dropdownElementi=Driver.getDriver().findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select=new Select(dropdownElementi);
        select.selectByVisibleText("Digital Cameras");
        String actualOption=select.getFirstSelectedOption().getText();
        String expectedKelime="Digital Cameras";
        Assert.assertEquals(expectedKelime,actualOption);

        Driver.closeDriver();

    }
}
