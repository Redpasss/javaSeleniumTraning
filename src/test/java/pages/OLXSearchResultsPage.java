package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class OLXSearchResultsPage extends BaseHelper {

    @FindBy(id = "rezultatipretrage") WebElement articlesHolder;

    WebDriver driver;
    public OLXSearchResultsPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void searchedResults() throws InterruptedException {
        Thread.sleep(2000);
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("rezultatipretrage")));
        List<WebElement> listitem = articlesHolder.findElements(By.className("artikal"));



        for(WebElement naslovi:listitem) {
            System.out.println(naslovi.getText());
        }



    }
}