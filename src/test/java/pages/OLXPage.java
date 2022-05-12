package pages;
import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class OLXPage extends BaseHelper {

    @FindBy(id="od") WebElement odFieldInsert;
    @FindBy(id="do") WebElement doFieldInsert;
    @FindBy(className = "dugmezaosvjezi") WebElement osvjezi;

    WebDriver driver;
    public OLXPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    private void navigateToOlxPage() {
        driver.get("https://www.olx.ba/");
        WebElement categoriesHolder = driver.findElement(By.id("pocetna-meni-lijevo"));
        js.executeScript("arguments[0].scrollIntoView();", categoriesHolder);
    }
    private void acceptCookies(){
        WebElement cookies = driver.findElement(By.id("cookiesBar"));
        WebElement clickOnCookies = cookies.findElement(By.className("cookie-close"));
        clickOnCookies.click();
    }

    private void clickOnKompjuteri() {
        wdWait.until(driver -> "complete".equals(((JavascriptExecutor) driver)
                .executeScript("return document.readyState")));
        WebElement categoriesHolder = driver.findElement(By.id("pocetna-meni-lijevo"));
        List<WebElement> category = categoriesHolder.findElements(By.tagName("li"));
        WebElement kompjuteri = category.get(6);
        kompjuteri.click();
    }
    private void clickOnMiningRigovi() {
        wdWait.until(driver -> "complete".equals(((JavascriptExecutor) driver)
                .executeScript("return document.readyState")));
        WebElement categoriesHolder = driver.findElement(By.id("filter-kategorije-div"));
        js.executeScript("arguments[0].scrollIntoView();", categoriesHolder);
        WebElement subCategories = categoriesHolder.findElement(By.tagName("ul"));
        WebElement subCategories2 = subCategories.findElement(By.tagName("ul"));
        List<WebElement> categoryFinal = subCategories2.findElements(By.tagName("li"));
        WebElement miningRigovi = categoryFinal.get(7);
        miningRigovi.click();
    }
    private void clickOnNovo() {
        WebElement stanjeHolder = driver.findElement(By.id("filter-stanje-div"));
        WebElement subStanjeHolder = stanjeHolder.findElement(By.tagName("div"));
        List<WebElement> list = subStanjeHolder.findElements(By.tagName("button"));
        WebElement novo = list.get(1);
        novo.click();
    }
    private void insertOd(String odValue){
        odFieldInsert.sendKeys(odValue);
    }
    private void insertDo(String doValue){
        doFieldInsert.sendKeys(doValue);
    }
    private void osvjeziRezultate(){
        wdWait.until(ExpectedConditions.elementToBeClickable(osvjezi));
        WebElement brojRezultata = driver.findElement(By.className("brojrezultata"));
        String brRez = brojRezultata.getText();
        System.out.println(brRez);
        osvjezi.click();
        wdWait.until(ExpectedConditions.invisibilityOfElementWithText(By.className("brojrezultata"),brRez));
        System.out.println(driver.findElement(By.className("brojrezultata")).getText());
    }
    public void search(String odValue, String doValue){
        navigateToOlxPage();
        acceptCookies();
        clickOnKompjuteri();
        clickOnMiningRigovi();
        clickOnNovo();
        insertOd(odValue);
        insertDo(doValue);
        osvjeziRezultate();
    }
}