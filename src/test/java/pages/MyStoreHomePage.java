package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import java.util.List;


public class MyStoreHomePage extends BaseHelper {
    @FindBy(className = "blockbestsellers")
    WebElement bestSeller;
    @FindBy(id = "blockbestsellers")
    WebElement blockBestSellers;
    @FindBy(id = "group_1")
    WebElement sizeID;
    @FindBy(id = "color_8")
    WebElement colorID;
    @FindBy(id = "add_to_cart")
    WebElement addToCartButton;
    @FindBy(className = "button-medium")
    WebElement proceedToCheckoutButton;
    @FindBy(xpath = "//input[@class='cart_quantity_input form-control grey']")
    WebElement valueField;

    String urlAddress = "http://automationpractice.com/index.php";
    String sizePick = "L";


    WebDriver driver;
    public MyStoreHomePage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    private void navigateToPage() {
        driver.get(urlAddress);
    }
    private void clickOnBestSellers(){
        bestSeller.click();
    }
    private void listBest(){
        wdWait.until(ExpectedConditions.elementToBeClickable(blockBestSellers));
        WebElement listBestSellers = blockBestSellers;
        List<WebElement> listOfItems = listBestSellers.findElements(By.className("product-container"));
        WebElement bestSellersItems=listOfItems.get(2);
        bestSellersItems.click();
    }
    private void selectSize(){
        Select size =new Select(sizeID);
        size.selectByVisibleText(sizePick);
    }
    private void selectColor(){
        wdWait.until(ExpectedConditions.elementToBeClickable(colorID));
        colorID.click();
    }
    private void addToCart(){
        addToCartButton.click();
    }
    private void proceedToCheckout(){
        wdWait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutButton));
        proceedToCheckoutButton.click();
    }
    private void qty() throws InterruptedException {
        wdWait.until(ExpectedConditions.elementToBeClickable(valueField));
        valueField.clear();
        valueField.sendKeys("4");
    }
    public void steps() throws InterruptedException {
        navigateToPage();
        clickOnBestSellers();
        listBest();
        selectSize();
        selectColor();
        addToCart();
        proceedToCheckout();
        qty();
    }
}
