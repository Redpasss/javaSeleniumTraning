package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BlicHomePage extends BaseHelper {

    @FindBy(id="search-open")
    WebElement searchOpen;
    @FindBy(id="search-input")
    WebElement inputField;
    @FindBy(xpath = "/html/body/header/div[1]/div/div[2]/form/button")
    WebElement searchStart;


    WebDriver driver;
    public BlicHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void navigateToBlicPage(){
        driver.get("https://www.blic.rs/");
    }
    private void searchOpenField() throws InterruptedException {
        wdWait.until(ExpectedConditions.elementToBeClickable(By.id("search-open")));
        searchOpen.click();
    }
    private void enterTermForSearch(){
        wdWait.until(ExpectedConditions.elementToBeClickable(By.id("search-input")));
        inputField.sendKeys("Comtrade");
    }
    private void clickOnSearchButton(){
        searchStart.click();
    }

    public void searchTerm() throws InterruptedException {
        navigateToBlicPage();
        searchOpenField();
        enterTermForSearch();
        clickOnSearchButton();

    }

}
