package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BlicHomePage;

import java.util.List;

public class BlicSearchTest extends BaseTest{
    String term = "Comtrade";

    @Test
    public void validateSearchFunctionality() throws InterruptedException {
        BlicHomePage searchBlicPage = new BlicHomePage(driver);
        searchBlicPage.searchTerm();

        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/main/section/div")));
        WebElement searchResults = driver.findElement(By.className("news-box"));
        Assert.assertTrue(searchResults.getText().contains(term));

//        WebElement newsCount = driver.findElement(By.className("news-box"));
//        System.out.println(newsCount.getSize());

        Thread.sleep(3000);
    }
}
