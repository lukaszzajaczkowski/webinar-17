import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ScreenshotUtil;

import java.util.List;

public class RadioButtonTests extends BaseTest {

    @Test
    public void thereAreThreeRadioButtonInForm() {
        driver.get("https://ultimateqa.com/simple-html-elements-for-automation/");

        ScreenshotUtil.takeScreenshot(driver, "radio.jpg");

        List<WebElement> radioButtons = driver.findElements(By.cssSelector("input[type='radio']"));

        // sprawdzenie czy pierwszy radio jest zaznaczony na starcie
        // System.out.println(radioButtons.get(0).isSelected());

        Assert.assertEquals(radioButtons.size(), 3);
    }

    @Test(dependsOnMethods = {"thereAreThreeRadioButtonInForm"})
    public void selectFemaleAndAssertOthersAreNotSelected() {
        WebElement femaleRadioButton = driver.findElement(By.cssSelector("input[type='radio'][value='female']"));
        femaleRadioButton.click();
        List<WebElement> selectedRadioButtons = driver.findElements(By.cssSelector("input[type='radio']:checked"));

        Assert.assertEquals(selectedRadioButtons.size(),1);
    }
}
