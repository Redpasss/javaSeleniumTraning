package tests;

import org.junit.Test;
import pages.connectHomePage;

public class ConnectTest extends BaseTest{

    @Test
    public void signInTest() throws InterruptedException {
        connectHomePage homePage = new connectHomePage(driver);

        homePage.signIN();

        Thread.sleep(2300);

    }


}
