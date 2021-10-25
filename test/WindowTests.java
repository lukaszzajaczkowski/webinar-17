import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowTests extends BaseTest {
    @Test
    public void multipleWindowsTests() {
        driver.get("https://the-internet.herokuapp.com/windows");

        driver.findElement(By.xpath("//*[@id=\"content\"]/div/a")).click();

        String mainWindow = driver.getWindowHandle();
        Set<String> allWindowHandle = driver.getWindowHandles();

        allWindowHandle.forEach(window -> {
            if (!mainWindow.equals(window)) {
                driver.switchTo().window(window);
            }
        });

        Assert.assertTrue(driver.findElement(By.tagName("h3")).getText().contains("New Window"));

        driver.close();
        driver.switchTo().window(mainWindow);

        Assert.assertNotNull(driver.findElement(By.xpath("//*[@id=\"content\"]/div/a")));
    }
}
