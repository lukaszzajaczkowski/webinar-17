import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocatorsTests extends BaseTest {

    @Test
    public void properCredentialsLoginTest() {
        driver.get("http://the-internet.herokuapp.com/login");

        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.sendKeys("tomsmith");

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("SuperSecretPassword!");

        WebElement loginButton = driver.findElement(By.tagName("button"));
        loginButton.click();

        WebElement successAlert = driver.findElement(By.cssSelector(".flash.success"));
        String successText = successAlert.getText();

        Assert.assertTrue(successText.contains("You logged into a secure area!"));
    }
}
