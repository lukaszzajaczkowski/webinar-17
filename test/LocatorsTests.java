import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Zadanie domowe
 * 1. wchodzimy na stronę http://sampleshop.inqa.pl/
 * 2. klikamy "Kontakt z nami" - nie korzystamy z By.linkText()
 *
 * Uzupełniamy formularz:
 * 1. Temat = webmaster
 * 2. podajemy e-mail
 * 3. wpisujemy treść
 *
 * Klikamy wyślij
 * Sprawdzamy czy wiadomość została wysłana
 */
public class LocatorsTests extends BaseTest {

    @Test
    public void xpathExample() {
        driver.get("http://sampleshop.inqa.pl/kontakt");

        WebElement meessageElement = driver.findElement(By.xpath("//*[@id=\"content\"]/section/form/section/div[5]/div/textarea"));

        Assert.assertTrue(meessageElement.isDisplayed());
    }

    @Test
    public void nameExample() {
        driver.get("http://sampleshop.inqa.pl/kontakt");

        WebElement emailElement = driver.findElement(By.name("from"));

        Assert.assertTrue(emailElement.isDisplayed());
    }

    @Test
    public void partialLinkTextExample() {
        driver.get("http://sampleshop.inqa.pl/");

        driver.findElement(By.partialLinkText("Terms")).click();

        Assert.assertEquals(driver.getCurrentUrl(), "http://sampleshop.inqa.pl/content/3-terms-and-conditions-of-use");
    }

    @Test
    public void linkTextExample() {
        driver.get("http://sampleshop.inqa.pl/");

        driver.findElement(By.linkText("Kontakt z nami")).click();

        Assert.assertEquals(driver.getCurrentUrl(), "http://sampleshop.inqa.pl/kontakt");
    }

    @Test
    public void idLocationExample() {
        driver.get("http://sampleshop.inqa.pl/");

        WebElement logoElement = driver.findElement(By.id("_desktop_logo"));

        Assert.assertTrue(logoElement.isDisplayed());
    }

    @Test
    public void tagNameExample() {
        driver.get("http://sampleshop.inqa.pl/kontakt");

        WebElement meessageElement = driver.findElement(By.tagName("textarea"));

        Assert.assertTrue(meessageElement.isDisplayed());
    }

    @Test
    public void cssSelectorExample() {
        driver.get("http://sampleshop.inqa.pl/");

        WebElement cardProductCount = driver.findElement(By.cssSelector("#_desktop_cart > div > div > span.cart-products-count"));
        String actualCount = cardProductCount.getText();

        Assert.assertEquals(actualCount, "(0)");
    }

    @Test
    public void classNameExample() {
        driver.get("http://sampleshop.inqa.pl/");

        WebElement cardProductCount = driver.findElement(By.className("cart-products-count"));
        String actualCount = cardProductCount.getText();

        Assert.assertEquals(actualCount, "(0)");
    }

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
