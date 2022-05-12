package pages;

import helpers.BaseHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeroKUAppPage extends BaseHelper
{
    @FindBy(name="username")
            WebElement userName;
    @FindBy(name="password")
            WebElement passwordValue;
    @FindBy(className="fa-sign-in")
            WebElement logInButton;



    WebDriver driver;
    public HeroKUAppPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    private void navigateToLoginPage(){
        driver.get("https://the-internet.herokuapp.com/login");
    }

    private void usernameField(){
        userName.sendKeys("tomsmith");
    }

    private void passwordField(){
        passwordValue.sendKeys("SuperSecretPassword!");
    }

    private void loginButton() {
        logInButton.click();
    }

    public void logInPage()
    {
        navigateToLoginPage();
        usernameField();
        passwordField();
        loginButton();
    }

}
