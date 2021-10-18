import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionsTests extends BaseTest {
    @Test
    public void openHoversPage() {
        driver.get("http://the-internet.herokuapp.com/hovers");
        String headerText = driver.findElement(By.tagName("h3")).getText();

        Assert.assertEquals(headerText, "Hovers");
    }

    @Test(dependsOnMethods = {"openHoversPage"})
    public void openUserProfile() {
        /*
        Z wykorzystaniem Actions:
        - stworzymy akcję
        - znajdziemy obrazek dla profilu 2
        - najedziemy na obrazek
        - znajdziemy link 'View profile' i klikniemy w niego
         */
        Actions openUserProfileAction = new Actions(driver);
        WebElement secondUserAvatar = driver.findElement(By.cssSelector("#content > div > div:nth-child(4) > img"));

        openUserProfileAction.moveToElement(secondUserAvatar)
                .pause(1000)
                .moveToElement(driver.findElement(By.cssSelector("#content > div > div:nth-child(4) > div > a")))
                .click()
                .build()
                .perform();

        Assert.assertTrue(driver.getCurrentUrl().contains("users/2"));
    }
}
