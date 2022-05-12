package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.HeroKUAppPage;

import static org.junit.Assert.assertTrue;

public class HKAppTest extends BaseTest
{
    String term = "Logout";

    @Test
    public void loginWithValidCredentials()
    {
        HeroKUAppPage loginPageHeroKU = new HeroKUAppPage(driver);
        loginPageHeroKU.logInPage();

        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("flash-messages")));
        WebElement logOutButton = driver.findElement(By.className("icon-signout"));
        assertTrue(logOutButton.getText().contains(term));

    }

    @Test
    public void loginInvalidCredentials()
    {

    }

}
