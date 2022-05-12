package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class connectHomePage extends BaseHelper {

    WebDriver driver;
    public connectHomePage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    private void navigateToHomePage(){
        driver.get("https://connect.garmin.com/");

    }

    private void clickOnSignInButton(){
        wdWait.until(driver -> "complete".equals(((JavascriptExecutor) driver)
                .executeScript("return document.readyState")));
        driver.findElement(By.className("c0149")).click();

    }

    public void signIN(){
        navigateToHomePage();
        clickOnSignInButton();
    }

}
