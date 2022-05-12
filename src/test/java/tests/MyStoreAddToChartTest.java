package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.MyStoreHomePage;

public class MyStoreAddToChartTest extends BaseTest
{
    String expected_value = "$108.00";

    @Test
    public void addToChart() throws InterruptedException {
        MyStoreHomePage stepsOnPage = new MyStoreHomePage(driver);
        stepsOnPage.steps();

        String total1 = "$27.00";
        wdWait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div[2]/table/tbody/tr/td[6]/span"), total1));
        String total_text = driver.findElement(By.id("total_product")).getText();
        Assert.assertEquals(expected_value, total_text);

        Thread.sleep(1000);
    }
}