package tests;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.OLXPage;
import java.util.List;

public class OLXTest extends BaseTest {
    String odValue = "66";
    String doValue = "70";

    @Test
    public void searchOlx() throws InterruptedException {
        OLXPage search = new OLXPage(driver);
        search.search(odValue, doValue);

        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("rezultatipretrage")));
        WebElement articlesHolder = driver.findElement(By.id("rezultatipretrage"));
        List<WebElement> listitem = articlesHolder.findElements(By.className("artikal"));
        listitem.removeIf( element -> element.findElement(By.className("naslov")).getText().isEmpty());

        for(WebElement naslovi:listitem) {
            System.out.println(naslovi.getText());
            Assert.assertTrue(naslovi.getText().contains("Mining"));
        }


        Thread.sleep(1000);
    }

}