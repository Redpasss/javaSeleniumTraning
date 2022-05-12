package tests;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class BrowserTest extends BaseTest
{
    @Test
    public void yahooSearchTest()
    {
        // Navigate to Yahoo Home Page
        driver.get("https://www.yahoo.com/");
        // Enter "QA Revealed" in search field.
        WebElement searchField = driver.findElement(By.id("ybar-sbq"));
        searchField.sendKeys("QA Revealed");
        // Click on magnifying glass.
        driver.findElement(By.id("ybar-search")).click();
        // "QA Revealed" is present
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("left")));
        WebElement results = driver.findElement(By.id("left"));
        Assert.assertTrue(results.getText().contains("QA Revealed"));
    }
}
