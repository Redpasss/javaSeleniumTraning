package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertTrue;

public class HerokuAppTest extends BaseTest {

    @Test
    public void logInValidCredentials() {
        //Navigate to https://the-internet.herokuapp.com/login
        driver.get("https://the-internet.herokuapp.com/login");
        //In Username field enter valid username (e.g tomsmith).
        WebElement usernameField= driver.findElement(By.id("username"));
        usernameField.sendKeys("tomsmith");
        //In Password field enter valid password (e.g SuperSecretPassword!).
        WebElement passwordField= driver.findElement(By.id("password"));
        passwordField.sendKeys("SuperSecretPassword!");
        //Click on Login button.
        driver.findElement(By.xpath("//i[contains(text(),'Login')]")).click();
        //Logout button is present.
        WebElement logOutbutton = driver.findElement(By.xpath("//i[contains(text(),'Logout')]"));
        assertTrue(logOutbutton.getText().contains("Logout"));
    }

    @Test
    public void loginInvalidCredentials() {
        //Navigate to https://the-internet.herokuapp.com/login
        driver.get("https://the-internet.herokuapp.com/login");
        //In Username field enter valid username (e.g tomsmith).
        WebElement usernameField= driver.findElement(By.id("username"));
        usernameField.sendKeys("tomsmith");
        //In Password field enter wrong password (e.g Vl4%$e72).
        WebElement passwordField= driver.findElement(By.id("password"));
        passwordField.sendKeys("Vl4%$e72");
        //Click on Login button.
        driver.findElement(By.xpath("//i[contains(text(),'Login')]")).click();
        //We get a message at the top of the page:  Your password is invalid!
        WebElement flashMessage = driver.findElement(By.id("flash"));
        Assert.assertTrue(flashMessage.getText().contains("Your password is invalid!"));

    }

}