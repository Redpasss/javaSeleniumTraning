package tests;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Olx extends BaseTest {

    @Test
    public void searchValidation()
    {
        driver.get("https://www.olx.ba/");
        driver.findElement(By.xpath("//body/div[4]/div[1]/div[3]/div[3]/div[1]/ul[1]/li[7]/a[1]")).click();
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[3]/div[1]/div/div[3]/div[2]/ul/ul/li[8]/a")).click();
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[3]/div[1]/div/div[3]/form/div[6]/div/button[2]")).click();

        WebElement od = driver.findElement(By.id("od"));
        od.sendKeys("66");

        WebElement doField = driver.findElement(By.id("do"));
        doField.sendKeys("70");

        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[3]/div[1]/div/div[3]/form/div[4]/span")).click();

        Assert.assertTrue(driver.getTitle().contains("Mining rigovi"));


    }

}
